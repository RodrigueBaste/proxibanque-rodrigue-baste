package org.exemple.configuration.proxibanque.si.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Adresse {

    private String rue;
    private String codePostal;
    private String ville;

    protected Adresse() {
    }

    public Adresse(String rue, String codePostal, String ville) {
        Objects.requireNonNull(rue, "La rue ne peut pas être null");
        Objects.requireNonNull(codePostal, "Le code postal ne peut pas être null");
        Objects.requireNonNull(ville, "La ville ne peut pas être null");

        validateAdresse(rue, codePostal, ville);

        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    private void validateAdresse(String rue, String codePostal, String ville) {
        if (rue.trim().isEmpty()) {
            throw new IllegalArgumentException("La rue ne peut pas être vide");
        }
        if (codePostal.trim().isEmpty()) {
            throw new IllegalArgumentException("Le code postal ne peut pas être vide");
        }
        if (ville.trim().isEmpty()) {
            throw new IllegalArgumentException("La ville ne peut pas être vide");
        }
    }

    public String getRue() {
        return rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(rue, adresse.rue) &&
               Objects.equals(codePostal, adresse.codePostal) &&
               Objects.equals(ville, adresse.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rue, codePostal, ville);
    }
}