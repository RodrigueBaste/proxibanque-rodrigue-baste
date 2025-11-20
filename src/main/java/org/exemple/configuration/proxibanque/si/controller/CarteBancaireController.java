package org.exemple.configuration.proxibanque.si.controller;

import org.exemple.configuration.proxibanque.si.domain.CarteBancaire;
import org.exemple.configuration.proxibanque.si.service.CarteBancaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartes")
public class CarteBancaireController {

    private final CarteBancaireService carteBancaireService;

    public CarteBancaireController(CarteBancaireService carteBancaireService) {
        this.carteBancaireService = carteBancaireService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteBancaire> obtenirCarte(@PathVariable Long id) {
        CarteBancaire carte = carteBancaireService.obtenirCarte(id);
        return ResponseEntity.ok(carte);
    }

    @GetMapping
    public ResponseEntity<List<CarteBancaire>> obtenirToutesLesCartes() {
        List<CarteBancaire> cartes = carteBancaireService.obtenirToutesLesCartes();
        return ResponseEntity.ok(cartes);
    }

    @GetMapping("/actives")
    public ResponseEntity<List<CarteBancaire>> obtenirCartesActives() {
        List<CarteBancaire> cartes = carteBancaireService.obtenirCartesActives();
        return ResponseEntity.ok(cartes);
    }

    @PostMapping("/{id}/activer")
    public ResponseEntity<CarteBancaire> activerCarte(@PathVariable Long id) {
        CarteBancaire carte = carteBancaireService.activerCarte(id);
        return ResponseEntity.ok(carte);
    }

    @PostMapping("/{id}/desactiver")
    public ResponseEntity<CarteBancaire> desactiverCarte(@PathVariable Long id) {
        CarteBancaire carte = carteBancaireService.desactiverCarte(id);
        return ResponseEntity.ok(carte);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCarte(@PathVariable Long id) {
        carteBancaireService.supprimerCarte(id);
        return ResponseEntity.noContent().build();
    }
}