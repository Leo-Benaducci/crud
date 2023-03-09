package br.com.soften.crud.controllers;

import br.com.soften.crud.models.dtos.SaleDto;
import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Sale;
import br.com.soften.crud.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
	private final SaleService saleService;

	@Autowired
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping("/find")
	public ResponseEntity<?> find(@RequestParam(required=false) Long id, @RequestParam(required=false) Long clientId) {
		if(id != null) {
			SaleDto sale = saleService.find(id);
			return ResponseEntity.ok(sale);
		}
		if(clientId != null) {
			List<SaleDto> sales = saleService.find(Client.builder().id(clientId).build());
			return ResponseEntity.ok(sales);
		}
		return ResponseEntity.badRequest().body("Please send a search parameter");
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody SaleDto sale) {
		Sale save = saleService.save(sale);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> save(@PathVariable long id) {
		saleService.delete(id);
		return ResponseEntity.ok().build();
	}
}
