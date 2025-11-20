package org.exemple.configuration.proxibanque.si.service;

import org.exemple.configuration.proxibanque.si.domain.CarteBancaire;
import org.exemple.configuration.proxibanque.si.domain.Client;
import org.exemple.configuration.proxibanque.si.domain.CompteCourant;
import org.exemple.configuration.proxibanque.si.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Service pour gérer les opérations liées aux clients
// Il encapsule la logique métier et interagit avec le repository ça nous permet de decoupler le controller de la couche d'acces aux données

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client creerClient(Client client) {
        return clientRepository.save(client);
    }

    public Client obtenirClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client non trouvé avec l'id: " + id));
    }

    public List<Client> obtenirTousLesClients() {
        return clientRepository.findAll();
    }

    public List<Client> obtenirClientsActifs() {
        return clientRepository.findByActifTrue();
    }

    public List<Client> rechercherClients(String recherche) {
        return clientRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(recherche, recherche);
    }

    public Client modifierClient(Long id, Client clientModifie) {
        Client client = obtenirClient(id);

        if (clientModifie.getNom() != null) {
            client = new Client(
                    clientModifie.getNom(),
                    clientModifie.getPrenom(),
                    clientModifie.getAdresse(),
                    clientModifie.getTelephone()
            );
        }

        return clientRepository.save(client);
    }

    public void archiverClient(Long id) {
        Client client = obtenirClient(id);
        client.archiver();
        clientRepository.save(client);
    }

    public void supprimerClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException("Client non trouvé avec l'id: " + id);
        }
        clientRepository.deleteById(id);
    }

    public Client ajouterCompteCourant(Long clientId, CompteCourant compteCourant) {
        Client client = obtenirClient(clientId);

        if (client.hasCompteCourant()) {
            throw new IllegalStateException("Le client possède déjà un compte courant");
        }

        client.ajouterCompteCourant(compteCourant);
        return clientRepository.save(client);
    }

    public Client ajouterCarte(Long clientId, CarteBancaire carte) {
        Client client = obtenirClient(clientId);
        client.ajouterCarte(carte);
        return clientRepository.save(client);
    }
}