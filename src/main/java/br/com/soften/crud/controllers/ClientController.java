package br.com.soften.crud.controllers;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/find")
	public ResponseEntity<?> find(@RequestParam(required=false) Long id, @RequestParam(required=false) String name) {
		if(id != null) {
			Client client = clientService.find(id);
			return ResponseEntity.ok(client);
		}
		if(name != null) {
			List<Client> clients = clientService.find(name);
			return ResponseEntity.ok(clients);
		}
		return ResponseEntity.badRequest().body("Please send a search parameter");
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Client client) {
		Client save = clientService.save(client);
		return ResponseEntity.ok(save);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> save(@PathVariable long id) {
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}
