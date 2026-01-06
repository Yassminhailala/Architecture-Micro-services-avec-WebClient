package ma.microservice.Servicevoiture.Services;

import ma.microservice.Servicevoiture.Entities.car;
import ma.microservice.Servicevoiture.Entities.Client;
import ma.microservice.Servicevoiture.Models.CarResponse;
import ma.microservice.Servicevoiture.repositories.Carrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private Carrepository carRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;


    private static final String CLIENT_SERVICE_URL =
            "http://SERVICE-CLIENT/api/client/";

    public car save(car car) {
        return carRepository.save(car);
    }

    public List<CarResponse> findAll() {
        return carRepository.findAll()
                .stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    public CarResponse findById(Long id) throws Exception {
        car car = carRepository.findById(id)
                .orElseThrow(() -> new Exception("Voiture non trouvée avec l'ID: " + id));
        return mapToCarResponse(car);
    }

    public Optional<CarResponse> findByIdOptional(Long id) {
        return carRepository.findById(id)
                .map(this::mapToCarResponse);
    }


    public List<CarResponse> findByClientId(Long clientId) {
        return carRepository.findByClientId(clientId)
                .stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }


    private CarResponse mapToCarResponse(car car) {
        Client client = null;
        try {
            if (car.getClientId() != null) {
                client = webClientBuilder.build()
                        .get()
                        .uri(CLIENT_SERVICE_URL + car.getClientId())
                        .retrieve()
                        .bodyToMono(Client.class)
                        .block();
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du client: " + e.getMessage());
        }

        return CarResponse.builder()
                .id(car.getId())
                .marque(car.getMarque())
                .model(car.getModel())
                .matricule(car.getMatricule())
                .client(client)
                .build();
    }
}
