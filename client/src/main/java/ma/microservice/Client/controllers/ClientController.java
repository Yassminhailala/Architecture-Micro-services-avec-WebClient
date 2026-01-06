package ma.microservice.Client.controllers;

import ma.microservice.Client.entities.Client;
import ma.microservice.Client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Obtenir la liste complète des clients
     * GET /api/client
     */
    @GetMapping
    public List<Client> obtenirTousClients() {
        return clientService.findAll();
    }

    /**
     * Rechercher un client par identifiant
     * GET /api/client/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenirClientParId(@PathVariable Long id) {
        try {
            Client client = clientService.findById(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("Client non trouvé: " + exception.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Créer un nouveau client
     * POST /api/client
     */
    @PostMapping
    public ResponseEntity<Client> creerClient(@RequestBody Client client) {
        Client clientCree = clientService.addClient(client);
        return new ResponseEntity<>(clientCree, HttpStatus.CREATED);
    }
}