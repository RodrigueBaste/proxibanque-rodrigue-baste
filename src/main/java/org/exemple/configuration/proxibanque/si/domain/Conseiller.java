package org.exemple.configuration.proxibanque.si.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conseiller extends Employe {

    private static final int MAX_CLIENTS = 10;

    private List<Client> clients;

    public Conseiller(String nom, String prenom, String numeroEmploye) {
        super(nom, prenom, numeroEmploye);
        this.clients = new ArrayList<>();
    }

    public void ajouterClient(Client client) {
        Objects.requireNonNull(client, "Le client ne peut pas être null");

        if (aAtteintLimiteClients()) {
            throw new IllegalStateException("Le conseiller a atteint le nombre maximum de clients");
        }

        clients.add(client);
    }

    public void retirerClient(Client client) {
        Objects.requireNonNull(client, "Le client ne peut pas être null");
        clients.remove(client);
    }

    public boolean aAtteintLimiteClients() {
        return clients.size() >= MAX_CLIENTS;
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }
}