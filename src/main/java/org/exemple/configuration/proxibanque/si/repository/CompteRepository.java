package org.exemple.configuration.proxibanque.si.repository;

import org.exemple.configuration.proxibanque.si.domain.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}