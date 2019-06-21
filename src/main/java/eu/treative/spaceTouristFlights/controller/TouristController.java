package eu.treative.spaceTouristFlights.controller;

import eu.treative.spaceTouristFlights.exception.ResourceNotFoundException;
import eu.treative.spaceTouristFlights.models.Tourist;
import eu.treative.spaceTouristFlights.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private TouristRepository touristRepository;

    @GetMapping("/tourists")
    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    @GetMapping("/tourists/{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable(value = "id") Long touristId) throws ResourceNotFoundException {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found on :: " + touristId));
        return ResponseEntity.ok().body(tourist);
    }

    @PostMapping("/tourists")
    public Tourist createTourist(@Valid @RequestBody Tourist tourist) {
        return touristRepository.save(tourist);
    }



}
