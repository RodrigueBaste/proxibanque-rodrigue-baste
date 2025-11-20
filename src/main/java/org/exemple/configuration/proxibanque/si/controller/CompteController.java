package org.exemple.configuration.proxibanque.si.controller;

import org.exemple.configuration.proxibanque.si.domain.Compte;
import org.exemple.configuration.proxibanque.si.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> obtenirCompte(@PathVariable Long id) {
        Compte compte = compteService.obtenirCompte(id);
        return ResponseEntity.ok(compte);
    }

    @GetMapping
    public ResponseEntity<List<Compte>> obtenirTousLesComptes() {
        List<Compte> comptes = compteService.obtenirTousLesComptes();
        return ResponseEntity.ok(comptes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCompte(@PathVariable Long id) {
        compteService.supprimerCompte(id);
        return ResponseEntity.noContent().build();
    }
}