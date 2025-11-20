package org.exemple.configuration.proxibanque.si.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CarteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCarte;

    @Enumerated(EnumType.STRING)
    private TypeCarte typeCarte;

    private boolean active;

    protected CarteBancaire() {
    }

    public CarteBancaire(String numeroCarte, TypeCarte typeCarte) {
        Objects.requireNonNull(numeroCarte, "Le numéro de carte ne peut pas être null");
        Objects.requireNonNull(typeCarte, "Le type de carte ne peut pas être null");

        validateNumeroCarte(numeroCarte);

        this.numeroCarte = numeroCarte;
        this.typeCarte = typeCarte;
        this.active = true;
    }

    private void validateNumeroCarte(String numero) {
        if (numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de carte ne peut pas être vide");
        }
    }

    public void activer() {
        this.active = true;
    }

    public void desactiver() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public TypeCarte getTypeCarte() {
        return typeCarte;
    }

    public Long getId() {
        return id;
    }
}
