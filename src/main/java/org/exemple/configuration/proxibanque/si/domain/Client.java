package org.exemple.configuration.proxibanque.si.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @Embedded
    private Adresse adresse;

    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    private CompteCourant compteCourant;

    @OneToOne(cascade = CascadeType.ALL)
    private CompteEpargne compteEpargne;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarteBancaire> cartes;

    private boolean actif;

    protected Client() {
    }

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
        this.cartes = new ArrayList<>();
        this.actif = true;
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

    public void ajouterCarte(CarteBancaire carte) {
        Objects.requireNonNull(carte, "La carte bancaire ne peut pas être null");
        cartes.add(carte);
    }

    public void retirerCarte(CarteBancaire carte) {
        Objects.requireNonNull(carte, "La carte bancaire ne peut pas être null");
        cartes.remove(carte);
    }

    public void desactiverToutesLesCartes() {
        for (CarteBancaire carte : cartes) {
            carte.desactiver();
        }
    }

    public void supprimerComptes() {
        this.compteCourant = null;
        this.compteEpargne = null;
    }

    public void archiver() {
        supprimerComptes();
        desactiverToutesLesCartes();
        this.actif = false;
    }

    public boolean isActif() {
        return actif;
    }

    public List<CarteBancaire> getCartes() {
        return new ArrayList<>(cartes);
    }

    public Long getId() {
        return id;
    }
}