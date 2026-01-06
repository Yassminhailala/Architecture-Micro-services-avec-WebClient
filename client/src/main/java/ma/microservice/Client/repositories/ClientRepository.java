package ma.microservice.Client.repositories;

import ma.microservice.Client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // L'interface JpaRepository fournit déjà toutes les opérations CRUD de base
    // Pas besoin de méthodes supplémentaires pour les opérations standard
}