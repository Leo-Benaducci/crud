package br.com.soften.crud.services;

import br.com.soften.crud.models.dtos.SaleDto;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.ItemSale;
import br.com.soften.crud.models.entities.Sale;
import br.com.soften.crud.repositories.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {
	private final SaleRepo saleRepo;
	private final ItemSaleService itemSaleService;

	@Autowired
	public SaleService(SaleRepo saleRepo, ItemSaleService itemSaleService) {
		this.saleRepo = saleRepo;
		this.itemSaleService = itemSaleService;
	}

	public Sale save(SaleDto dto) {
		if(dto.getSale().getId() != 0) {
			List<ItemSale> itemSales = itemSaleService.find(dto.getSale());
			itemSales.removeIf(f -> dto.getItems().stream().anyMatch(i -> i.getId() == f.getId()));
			itemSales.forEach(f -> itemSaleService.delete(f.getId()));
		}
		saleRepo.save(dto.getSale());
		BigDecimal total = BigDecimal.ZERO;
		for(ItemSale f: dto.getItems()) {
			f.setSale(dto.getSale());
			itemSaleService.save(f);
			total = total.add(BigDecimal.valueOf(f.getQty() * f.getProduct().getPrice()));
		}
		dto.getSale().setPrice(total.doubleValue());
		saleRepo.save(dto.getSale());
		return dto.getSale();
	}

	public SaleDto find(long id) {
		Sale sale = saleRepo.findById(id).orElse(null);
		if(sale != null){
			List<ItemSale> itemSales = itemSaleService.find(sale);
			return SaleDto.builder().sale(sale).items(itemSales).build();
		}
		return null;
	}

	public List<SaleDto> find(Client client) {
		List<SaleDto> saleDtos = new ArrayList<>();
		List<Sale> sales = saleRepo.findAllByClient(client);
		for(Sale sale: sales) {
			if(sale != null){
				List<ItemSale> itemSales = itemSaleService.find(sale);
				saleDtos.add(SaleDto.builder().sale(sale).items(itemSales).build());
			}
		}
		return saleDtos;
	}

	public void delete(long id) {
		List<ItemSale> itemSales = itemSaleService.find(Sale.builder().id(id).build());
		for(ItemSale itemSale: itemSales) {
			itemSaleService.delete(itemSale.getId());
		}
		saleRepo.deleteById(id);
	}
}
