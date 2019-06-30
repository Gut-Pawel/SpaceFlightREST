package eu.treative.spaceTouristFlights.controller;

import com.sun.xml.internal.ws.developer.Serialization;
import eu.treative.spaceTouristFlights.exception.ResourceNotFoundException;
import eu.treative.spaceTouristFlights.models.Flight;
import eu.treative.spaceTouristFlights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.RejectedExecutionException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    /* GET ALL FLIGHTS */
    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    /* GET FLIGHT BY ID */
    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable(name = "id") long flightId) throws ResourceNotFoundException {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight with " + flightId + " id not found"));
        return ResponseEntity.ok().body(flight);
    }

    /* CREATE NEW FLIGHT */
    @PostMapping("/flights")
    public Flight createFlight(@Valid @RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    /* DELETE FLIGHT */
    @DeleteMapping("/flights/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable(value = "id") Long flightID) throws ResourceNotFoundException{
        Flight flight = flightRepository.findById(flightID)
                .orElseThrow(() -> new ResourceNotFoundException("Flight " + flightID + " id not found"));
        flightRepository.delete(flight);

        return ResponseEntity.ok().build();
    }

}
