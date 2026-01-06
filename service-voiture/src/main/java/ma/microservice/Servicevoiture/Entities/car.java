package ma.microservice.vehicule.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicules")
public class automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;

    private String constructeur;
    private String plaqueImmatriculation;
    private String modele;

    @Column(name = "id_utilisateur")
    private Long identifiantUtilisateur;

    @Transient
    private Utilisateur utilisateur;

    public automobile() {
    }

    public automobile(Long identifiant, String constructeur, String plaqueImmatriculation,
                      String modele, Long identifiantUtilisateur, Utilisateur utilisateur) {
        this.identifiant = identifiant;
        this.constructeur = constructeur;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.modele = modele;
        this.identifiantUtilisateur = identifiantUtilisateur;
        this.utilisateur = utilisateur;
    }

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Long getIdentifiantUtilisateur() {
        return identifiantUtilisateur;
    }

    public void setIdentifiantUtilisateur(Long identifiantUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}