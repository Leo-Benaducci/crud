package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	private final ProductRepo productRepo;

	@Autowired
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public Product save(Product product) {
		return productRepo.save(product);
	}

	public Product find(long id) {
		return productRepo.findById(id).orElse(null);
	}

	public List<Product> find(String name) {
		return productRepo.findAllByDescriptionContaining(name);
	}

	public void delete(long id) {
		productRepo.deleteById(id);
	}
}
