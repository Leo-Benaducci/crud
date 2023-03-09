package br.com.soften.crud.controllers;

import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/find")
	public ResponseEntity<?> find(@RequestParam(required=false) Long id, @RequestParam(required=false) String description) {
		if(id != null) {
			Product product = productService.find(id);
			return ResponseEntity.ok(product);
		}
		if(description != null) {
			List<Product> products = productService.find(description);
			return ResponseEntity.ok(products);
		}
		return ResponseEntity.badRequest().body("Please send a search parameter");
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Product product) {
		Product save = productService.save(product);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> save(@PathVariable long id) {
		productService.delete(id);
		return ResponseEntity.ok().build();
	}
}
