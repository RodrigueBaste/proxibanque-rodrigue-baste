package org.exemple.configuration.proxibanque.si.repository;

import org.exemple.configuration.proxibanque.si.domain.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {

    List<CarteBancaire> findByActiveTrue();
}