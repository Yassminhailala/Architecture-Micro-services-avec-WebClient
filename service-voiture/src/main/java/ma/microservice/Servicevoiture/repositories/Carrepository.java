package ma.microservice.vehicule.depots;

import ma.microservice.vehicule.modele.automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface DepotAutomobile extends JpaRepository<automobile, Long> {
    Collection<automobile> trouverParIdentifiantUtilisateur(Long identifiantUtilisateur);
}