package ma.microservice.vehicule.modele;

public class Utilisateur {
    private Long identifiant;
    private String nomComplet;
    private Float age;

    public Utilisateur() {
    }

    public Utilisateur(Long identifiant, String nomComplet, Float age) {
        this.identifiant = identifiant;
        this.nomComplet = nomComplet;
        this.age = age;
    }

    public Long getIdentifiant() {
        return identifiant;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public Float getAge() {
        return age;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) return true;
        if (objet == null || getClass() != objet.getClass()) return false;
        Utilisateur utilisateur = (Utilisateur) objet;
        return java.util.Objects.equals(identifiant, utilisateur.identifiant) &&
                java.util.Objects.equals(nomComplet, utilisateur.nomComplet) &&
                java.util.Objects.equals(age, utilisateur.age);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(identifiant, nomComplet, age);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "identifiant=" + identifiant +
                ", nomComplet='" + nomComplet + '\'' +
                ", age=" + age +
                '}';
    }
}