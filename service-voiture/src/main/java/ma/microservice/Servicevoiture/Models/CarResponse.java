package ma.microservice.vehicule.reponses;

import ma.microservice.vehicule.modele.Utilisateur;

public class ReponseVehicule {
    private Long identifiant;
    private String constructeur;
    private String modele;
    private String plaqueImmatriculation;
    private Utilisateur utilisateur;

    public ReponseVehicule() {
    }

    public ReponseVehicule(Long identifiant, String constructeur, String modele,
                           String plaqueImmatriculation, Utilisateur utilisateur) {
        this.identifiant = identifiant;
        this.constructeur = constructeur;
        this.modele = modele;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.utilisateur = utilisateur;
    }

    public Long getIdentifiant() {
        return identifiant;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public String getModele() {
        return modele;
    }

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public static Constructeur constructeur() {
        return new Constructeur();
    }

    public static class Constructeur {
        private Long identifiant;
        private String constructeur;
        private String modele;
        private String plaqueImmatriculation;
        private Utilisateur utilisateur;

        public Constructeur identifiant(Long identifiant) {
            this.identifiant = identifiant;
            return this;
        }

        public Constructeur constructeur(String constructeur) {
            this.constructeur = constructeur;
            return this;
        }

        public Constructeur modele(String modele) {
            this.modele = modele;
            return this;
        }

        public Constructeur plaqueImmatriculation(String plaqueImmatriculation) {
            this.plaqueImmatriculation = plaqueImmatriculation;
            return this;
        }

        public Constructeur utilisateur(Utilisateur utilisateur) {
            this.utilisateur = utilisateur;
            return this;
        }

        public ReponseVehicule construire() {
            return new ReponseVehicule(identifiant, constructeur, modele,
                    plaqueImmatriculation, utilisateur);
        }
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) return true;
        if (objet == null || getClass() != objet.getClass()) return false;
        ReponseVehicule reponse = (ReponseVehicule) objet;
        return java.util.Objects.equals(identifiant, reponse.identifiant) &&
                java.util.Objects.equals(constructeur, reponse.constructeur) &&
                java.util.Objects.equals(modele, reponse.modele) &&
                java.util.Objects.equals(plaqueImmatriculation, reponse.plaqueImmatriculation) &&
                java.util.Objects.equals(utilisateur, reponse.utilisateur);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(identifiant, constructeur, modele,
                plaqueImmatriculation, utilisateur);
    }

    @Override
    public String toString() {
        return "ReponseVehicule{" +
                "identifiant=" + identifiant +
                ", constructeur='" + constructeur + '\'' +
                ", modele='" + modele + '\'' +
                ", plaqueImmatriculation='" + plaqueImmatriculation + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}