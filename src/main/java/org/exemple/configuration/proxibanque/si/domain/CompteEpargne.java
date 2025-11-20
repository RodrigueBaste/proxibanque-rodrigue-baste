package org.exemple.configuration.proxibanque.si.domain;

import java.time.LocalDate;

public class CompteEpargne extends Compte {

    // Constantes de la classe
    private static final double TAUX_PAR_DEFAUT = 0.03;

    private double tauxRemuneration; 

    // Constructeur principal
    public CompteEpargne(String numeroCompte, double solde, LocalDate dateOuverture, double tauxRemuneration) {
        super(numeroCompte, solde, dateOuverture);
        this.tauxRemuneration = tauxRemuneration;
    }

    // Surcharge du constructeur avec le taux par défaut
    public CompteEpargne(String numeroCompte, double solde, LocalDate dateOuverture) {
        this(numeroCompte, solde, dateOuverture, TAUX_PAR_DEFAUT);
    }

    public double getTauxRemuneration() {
        return tauxRemuneration;
    }
}
