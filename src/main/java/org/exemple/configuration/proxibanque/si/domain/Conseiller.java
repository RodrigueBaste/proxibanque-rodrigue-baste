package org.exemple.configuration.proxibanque.si.domain;

import java.util.List;

public class Conseiller extends Employe {
    // Nos constantes de la classe
    private static final int MAX_CLIENTS = 10L;

    private List<Client> clients;
    
    // Nos méthodes métier
    private void ajouterClient(Client client) {
        if (clients.size() < MAX_CLIENTS) {
            clients.add(client);
        } else {
            throw new IllegalStateException("Le conseiller a atteint le nombre maximum de clients.");
        }
    }
    
    private void retirerClient(Client client) {
        clients.remove(client);
    }
    
    private boolean aAtteintLimiteClients() {
        return clients.size() >= MAX_CLIENTS;
    }

    public List<Client> getClients() {
        return clients;
    }
}
