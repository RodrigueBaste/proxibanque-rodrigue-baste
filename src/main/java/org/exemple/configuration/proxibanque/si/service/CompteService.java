package org.exemple.configuration.proxibanque.si.service;

import org.exemple.configuration.proxibanque.si.domain.Compte;
import org.exemple.configuration.proxibanque.si.repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public Compte obtenirCompte(Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compte non trouvé avec l'id: " + id));
    }

    public List<Compte> obtenirTousLesComptes() {
        return compteRepository.findAll();
    }

    public void supprimerCompte(Long id) {
        if (!compteRepository.existsById(id)) {
            throw new IllegalArgumentException("Compte non trouvé avec l'id: " + id);
        }
        compteRepository.deleteById(id);
    }
}