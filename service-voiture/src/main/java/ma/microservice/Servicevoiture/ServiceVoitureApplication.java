package ma.microservice.vehicule;

import ma.microservice.vehicule.modele.automobile;
import ma.microservice.vehicule.depots.DepotAutomobile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationVehicule {

    public static void main(String[] arguments) {
        SpringApplication.run(ApplicationVehicule.class, arguments);
    }

    @Bean
    public CommandLineRunner initialiserDonnees(DepotAutomobile depotVehicule) {
        return args -> {
            if (depotVehicule.compter() == 0) {
                depotVehicule.enregistrer(new automobile(null, "Mercedes", "GHI789", "Classe C", 3L, null));
                depotVehicule.enregistrer(new automobile(null, "BMW", "JKL012", "Série 3", 4L, null));
                depotVehicule.enregistrer(new automobile(null, "Audi", "MNO345", "A4", 3L, null));
                System.out.println("Base de données initialisée avec des véhicules d'exemple!");
            }
        };
    }
}