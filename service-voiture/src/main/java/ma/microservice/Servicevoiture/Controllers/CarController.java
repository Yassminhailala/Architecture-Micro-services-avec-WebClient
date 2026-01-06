package ma.microservice.Servicevoiture.Controllers;

import ma.microservice.Servicevoiture.Entities.car;
import ma.microservice.Servicevoiture.Models.CarResponse;
import ma.microservice.Servicevoiture.Services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<car> save(@RequestBody car car) {
        ma.microservice.Servicevoiture.Entities.car saved = carService.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> findById(@PathVariable Long id) {
        return carService.findByIdOptional(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byClient/{clientId}")
    public List<CarResponse> findByClient(@PathVariable Long clientId) {
        return carService.findByClientId(clientId);
    }
}
