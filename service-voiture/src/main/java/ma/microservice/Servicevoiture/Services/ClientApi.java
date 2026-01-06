package ma.microservice.vehicule.services;

import ma.microservice.vehicule.modele.Utilisateur;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiUtilisateur {
    private final WebClient.Builder constructeurClientWeb;

    public ApiUtilisateur(WebClient.Builder constructeurClientWeb) {
        this.constructeurClientWeb = constructeurClientWeb;
    }

    public Utilisateur obtenirUtilisateurParIdentifiant(Long identifiant) {
        return constructeurClientWeb.build()
                .methodGet()
                .uri("http://SERVICE-CLIENT/api/client/" + identifiant)
                .recuperer()
                .corpsVersMono(Utilisateur.class)
                .bloquer();
    }
}