package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.ItemSale;
import br.com.soften.crud.models.entities.Sale;
import br.com.soften.crud.repositories.ItemSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemSaleService {
	private final ItemSaleRepo itemSaleRepo;

	@Autowired
	public ItemSaleService(ItemSaleRepo itemSaleRepo) {
		this.itemSaleRepo = itemSaleRepo;
	}

	public ItemSale save(ItemSale itemSale) {
		return itemSaleRepo.save(itemSale);
	}

	public ItemSale find(long id) {
		return itemSaleRepo.findById(id).orElse(null);
	}

	public List<ItemSale> find(Sale sale) {
		return itemSaleRepo.findAllBySale(sale);
	}

	public void delete(long id) {
		itemSaleRepo.deleteById(id);
	}
}
