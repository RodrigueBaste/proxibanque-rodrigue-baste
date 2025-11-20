package org.exemple.configuration.proxibanque.si.service;

import org.exemple.configuration.proxibanque.si.domain.CarteBancaire;
import org.exemple.configuration.proxibanque.si.repository.CarteBancaireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarteBancaireService {

    private final CarteBancaireRepository carteBancaireRepository;

    public CarteBancaireService(CarteBancaireRepository carteBancaireRepository) {
        this.carteBancaireRepository = carteBancaireRepository;
    }

    public CarteBancaire obtenirCarte(Long id) {
        return carteBancaireRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carte bancaire non trouvée avec l'id: " + id));
    }

    public List<CarteBancaire> obtenirToutesLesCartes() {
        return carteBancaireRepository.findAll();
    }

    public List<CarteBancaire> obtenirCartesActives() {
        return carteBancaireRepository.findByActiveTrue();
    }

    public CarteBancaire activerCarte(Long id) {
        CarteBancaire carte = obtenirCarte(id);
        carte.activer();
        return carteBancaireRepository.save(carte);
    }

    public CarteBancaire desactiverCarte(Long id) {
        CarteBancaire carte = obtenirCarte(id);
        carte.desactiver();
        return carteBancaireRepository.save(carte);
    }

    public void supprimerCarte(Long id) {
        if (!carteBancaireRepository.existsById(id)) {
            throw new IllegalArgumentException("Carte bancaire non trouvée avec l'id: " + id);
        }
        carteBancaireRepository.deleteById(id);
    }
}