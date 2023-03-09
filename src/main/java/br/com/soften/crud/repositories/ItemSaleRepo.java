package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.ItemSale;
import br.com.soften.crud.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemSaleRepo extends JpaRepository<ItemSale, Long> {
	List<ItemSale> findAllBySale(Sale sale);
}
