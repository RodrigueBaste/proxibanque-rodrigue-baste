package org.exemple.configuration.proxibanque.si.controller;

import org.exemple.configuration.proxibanque.si.domain.Client;
import org.exemple.configuration.proxibanque.si.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// On va decoupler le controller grace a un service layer

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> creerClient(@RequestBody Client client) {
        Client nouveauClient = clientService.creerClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> obtenirClient(@PathVariable Long id) {
        Client client = clientService.obtenirClient(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> obtenirTousLesClients() {
        List<Client> clients = clientService.obtenirTousLesClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/actifs")
    public ResponseEntity<List<Client>> obtenirClientsActifs() {
        List<Client> clients = clientService.obtenirClientsActifs();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/rechercher")
    public ResponseEntity<List<Client>> rechercherClients(@RequestParam String recherche) {
        List<Client> clients = clientService.rechercherClients(recherche);
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(@PathVariable Long id, @RequestBody Client client) {
        Client clientModifie = clientService.modifierClient(id, client);
        return ResponseEntity.ok(clientModifie);
    }

    @PostMapping("/{id}/archiver")
    public ResponseEntity<Void> archiverClient(@PathVariable Long id) {
        clientService.archiverClient(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
        return ResponseEntity.noContent().build();
    }
}