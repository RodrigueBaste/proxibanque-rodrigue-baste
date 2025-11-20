package org.exemple.configuration.proxibanque.si.domain;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class CompteCourant extends Compte {

    private static final double DECOUVERT_PAR_DEFAUT = 1000.0;

    private double decouvertAutorise;

    protected CompteCourant() {
    }

    public CompteCourant(String numeroCompte, double solde, LocalDate dateOuverture, double decouvertAutorise) {
        super(numeroCompte, solde, dateOuverture);
        this.decouvertAutorise = decouvertAutorise;
    }

    public CompteCourant(String numeroCompte, double solde, LocalDate dateOuverture) {
        this(numeroCompte, solde, dateOuverture, DECOUVERT_PAR_DEFAUT);
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
}
