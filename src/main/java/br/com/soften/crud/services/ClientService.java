package br.com.soften.crud.services;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

	private final ClientRepo clientRepo;

	@Autowired
	public ClientService(ClientRepo clientRepo) {
		this.clientRepo = clientRepo;
	}

	public Client save(Client client) {
		return clientRepo.save(client);
	}

	public Client find(long id) {
		return clientRepo.findById(id).orElse(null);
	}

	public List<Client> find(String name) {
		return clientRepo.findAllByNameContaining(name);
	}

	public void delete(long id) {
		clientRepo.deleteById(id);
	}
}
