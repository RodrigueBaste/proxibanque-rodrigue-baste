package org.exemple.configuration.proxibanque.si.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Agence {

    private static final int LONGUEUR_NUMERO_IDENTIFICATION = 5;
    private static final String REGEX_ALPHANUMERIQUE = "^[A-Za-z0-9]{5}$";

    private String numeroIdentification;
    private LocalDate dateCreation;
    private Gerant gerant;
    private List<Conseiller> conseillers;

    public Agence(String numeroIdentification, LocalDate dateCreation) {
        Objects.requireNonNull(numeroIdentification, "Le numéro d'identification ne peut pas être null");
        Objects.requireNonNull(dateCreation, "La date de création ne peut pas être null");

        validateNumeroIdentification(numeroIdentification);

        this.numeroIdentification = numeroIdentification;
        this.dateCreation = dateCreation;
        this.conseillers = new ArrayList<>();
    }

    
    private void validateNumeroIdentification(String numero) {
        if (!isNumeroIdentificationValide(numero)) {
            throw new IllegalArgumentException(
                "Le numéro d'identification doit contenir exactement 5 caractères alphanumériques"
            );
        }
    }

    private boolean isNumeroIdentificationValide(String numero) {
        return numero.length() == LONGUEUR_NUMERO_IDENTIFICATION
            && numero.matches(REGEX_ALPHANUMERIQUE);
    }

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void affecterGerant(Gerant gerant) {
        Objects.requireNonNull(gerant, "Le gérant ne peut pas être null");
        this.gerant = gerant;
    }

    public void ajouterConseiller(Conseiller conseiller) {
        Objects.requireNonNull(conseiller, "Le conseiller ne peut pas être null");
        conseillers.add(conseiller);
    }

    public void retirerConseiller(Conseiller conseiller) {
        Objects.requireNonNull(conseiller, "Le conseiller ne peut pas être null");
        conseillers.remove(conseiller);
    }

    public Gerant getGerant() {
        return gerant;
    }

    public List<Conseiller> getConseillers() {
        return new ArrayList<>(conseillers);
    }
}