package org.exemple.configuration.proxibanque.si.domain;

import java.time.LocalDate;

public class CompteCourant extends Compte {

    // Constantes de la classe
    private static final double DECOUVERT_PAR_DEFAUT = 1000.0;

    private double decouvertAutorise;

    // Constructeur principal
    public CompteCourant(String numeroCompte, double solde, LocalDate dateOuverture, double decouvertAutorise) {
        super(numeroCompte, solde, dateOuverture);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Surcharge du constructeur avec le découvert par défaut
    public CompteCourant(String numeroCompte, double solde, LocalDate dateOuverture) {
        this(numeroCompte, solde, dateOuverture, DECOUVERT_PAR_DEFAUT);
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
}
