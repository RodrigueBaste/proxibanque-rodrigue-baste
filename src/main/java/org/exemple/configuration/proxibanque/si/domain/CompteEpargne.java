package org.exemple.configuration.proxibanque.si.domain;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class CompteEpargne extends Compte {

    private static final double TAUX_PAR_DEFAUT = 0.03;

    private double tauxRemuneration;

    protected CompteEpargne() {
    }

    public CompteEpargne(String numeroCompte, double solde, LocalDate dateOuverture, double tauxRemuneration) {
        super(numeroCompte, solde, dateOuverture);
        this.tauxRemuneration = tauxRemuneration;
    }

    public CompteEpargne(String numeroCompte, double solde, LocalDate dateOuverture) {
        this(numeroCompte, solde, dateOuverture, TAUX_PAR_DEFAUT);
    }

    public double getTauxRemuneration() {
        return tauxRemuneration;
    }
}
