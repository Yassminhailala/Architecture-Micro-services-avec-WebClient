package ma.microservice.Client.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;

    private String nom;

    private Float age;

    /**
     * Constructeur par défaut requis par JPA
     */
    public Client() {}

    /**
     * Constructeur avec paramètres
     */
    public Client(String nom, Float age) {
        this.nom = nom;
        this.age = age;
    }

    // Accesseurs et mutateurs
    public Long getId() {
        return identifiant;
    }

    public void setId(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }
}