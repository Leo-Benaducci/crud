package br.com.soften.crud.repositories;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {
	List<Sale> findAllByClient(Client client);
}
