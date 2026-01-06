package ma.microservice.Client;

import ma.microservice.Client.entities.Client;
import ma.microservice.Client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner insererClientsInitiaux(ClientRepository repositoryClients) {
        return parametres -> {
            // Ajout de données de démonstration au démarrage
            repositoryClients.save(new Client("Yassin KARIMI", 28f));
            repositoryClients.save(new Client("Leila BENANI", 25f));
            repositoryClients.save(new Client("Omar CHERKAOUI", 30f));
        };
    }
}