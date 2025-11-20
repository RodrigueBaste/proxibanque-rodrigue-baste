package org.exemple.configuration.proxibanque.si.domain;

import java.util.Objects;

public abstract class Employe {
    private String nom;
    private String prenom;
    private String numeroEmploye;

    protected Employe(String nom, String prenom, String numeroEmploye) {
        Objects.requireNonNull(nom, "Le nom ne peut pas être null");
        Objects.requireNonNull(prenom, "Le prénom ne peut pas être null");
        Objects.requireNonNull(numeroEmploye, "Le numéro d'employé ne peut pas être null");
        validateProperties(nom, prenom, numeroEmploye);
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEmploye = numeroEmploye;
    }

    private void validateProperties(String nom, String prenom, String numeroEmploye) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        if (prenom == null || prenom.isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        if (numeroEmploye == null || numeroEmploye.isEmpty()) {
            throw new IllegalArgumentException("Le numéro d'employé ne peut pas être vide");
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroEmploye() {
        return numeroEmploye;
    }
}
