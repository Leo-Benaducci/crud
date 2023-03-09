package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	List<Product> findAllByDescriptionContaining(String description);
}
