package eu.treative.spaceTouristFlights.controller;

import eu.treative.spaceTouristFlights.exception.ResourceNotFoundException;
import eu.treative.spaceTouristFlights.models.Flight;
import eu.treative.spaceTouristFlights.models.ListOfTouristToFlight;
import eu.treative.spaceTouristFlights.repository.FlightRepository;
import eu.treative.spaceTouristFlights.repository.ListOfTouristToFlightRepository;
import eu.treative.spaceTouristFlights.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ListOfTouristToFlightController {
    @Autowired
    private ListOfTouristToFlightRepository repository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    TouristRepository touristRepository;

    @GetMapping("/touristListToFlight")
    public List<?> getAllListOfTouristToFlight() {
        return repository.findAll();
    }

    @GetMapping("/touristsListOfFlights/tourist_id/{id}")
    public Set<?> getAllFlightsOfTourist(@PathVariable (value = "id") Long touristID) {

        Set<ListOfTouristToFlight> list = new HashSet<>();

        for(ListOfTouristToFlight a : repository.findAll()) {
            if(a.getTouristID().equals(touristID)) {
                list.add(a);
            }
        }
        return list;
    }

    @PostMapping("/touristListToFlight")
    public ResponseEntity<ListOfTouristToFlight> addTouristToFlight(
           @Valid @RequestBody ListOfTouristToFlight listOfTouristToFlight
    ) {
        for(ListOfTouristToFlight a : repository.findAll()) {
            if(a.getFlightID().equals(listOfTouristToFlight.getFlightID()) && a.getTouristID().equals(listOfTouristToFlight.getTouristID())) {
                System.out.println("Istnieje juz taka rezerwacja !!!");
                return null;
            }

            Long flightID = listOfTouristToFlight.getFlightID();
            Long touristID = listOfTouristToFlight.getTouristID();

            flightRepository.findById(flightID);

            if(!flightRepository.findById(flightID).isPresent()) {
                System.out.println("Lot o podanym id " + flightID + " nie istnieje ");
                new ResourceNotFoundException("Lot o podanym id " + flightID + " nie istnieje ");
                return null;
            }

            else if(!touristRepository.findById(touristID).isPresent()) {
                System.out.println("Turysta o podanym id " + touristID + " nie istnieje");
                return null;
            }
        }

        return ResponseEntity.ok().body(repository.save(listOfTouristToFlight));
    }

}
