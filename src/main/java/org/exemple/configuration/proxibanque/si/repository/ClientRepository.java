package org.exemple.configuration.proxibanque.si.repository;

import org.exemple.configuration.proxibanque.si.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Méthode pour trouver tous les clients actifs
    List<Client> findByActifTrue();
    // Méthode pour rechercher des clients par nom ou prénom (insensible à la casse)
    List<Client> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom);
}