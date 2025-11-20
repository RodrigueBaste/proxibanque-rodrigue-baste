package org.exemple.configuration.proxibanque.si.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Compte {

    private String numeroCompte;
    private double solde;
    private LocalDate dateOuverture;

    protected Compte(String numeroCompte, double solde, LocalDate dateOuverture) {
        Objects.requireNonNull(numeroCompte, "Le numéro de compte ne peut pas être null");
        Objects.requireNonNull(dateOuverture, "La date d'ouverture ne peut pas être null");

        // On fait du SRP en déléguant la validation du numéro de compte à une méthode dédiée
        validateNumeroCompte(numeroCompte);

        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }

    // On verifie que le numéro de compte n'est pas vide
    private void validateNumeroCompte(String numero) {
        if (numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de compte ne peut pas être vide");
        }
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }
}
