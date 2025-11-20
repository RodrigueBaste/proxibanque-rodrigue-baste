package org.exemple.configuration.proxibanque.si.domain;

import java.util.Objects;

public class Client {

    private String nom;
    private String prenom;
    private Adresse adresse;
    private String telephone;
    private CompteCourant compteCourant;
    private CompteEpargne compteEpargne;

    public Client(String nom, String prenom, Adresse adresse, String telephone) {
        Objects.requireNonNull(nom, "Le nom ne peut pas être null");
        Objects.requireNonNull(prenom, "Le prénom ne peut pas être null");
        Objects.requireNonNull(adresse, "L'adresse ne peut pas être null");
        Objects.requireNonNull(telephone, "Le téléphone ne peut pas être null");

        validateProperties(nom, prenom, telephone);

        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    private void validateProperties(String nom, String prenom, String telephone) {
        if (nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        if (prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        if (telephone.trim().isEmpty()) {
            throw new IllegalArgumentException("Le téléphone ne peut pas être vide");
        }
    }

    public void ajouterCompteCourant(CompteCourant compte) {
        Objects.requireNonNull(compte, "Le compte courant ne peut pas être null");
        this.compteCourant = compte;
    }

    public void ajouterCompteEpargne(CompteEpargne compte) {
        Objects.requireNonNull(compte, "Le compte épargne ne peut pas être null");
        this.compteEpargne = compte;
    }

    public boolean hasCompteCourant() {
        return compteCourant != null;
    }

    public boolean hasCompteEpargne() {
        return compteEpargne != null;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }
}