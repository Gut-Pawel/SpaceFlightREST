package eu.treative.spaceTouristFlights.controller;

import eu.treative.spaceTouristFlights.exception.ResourceNotFoundException;
import eu.treative.spaceTouristFlights.models.Flight;
import eu.treative.spaceTouristFlights.models.ListOfTouristToFlight;
import eu.treative.spaceTouristFlights.models.Tourist;
import eu.treative.spaceTouristFlights.repository.FlightRepository;
import eu.treative.spaceTouristFlights.repository.ListOfTouristToFlightRepository;
import eu.treative.spaceTouristFlights.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    private TouristRepository touristRepository;

    /* GET ALL LIST */
    @GetMapping("/touristListToFlight")
    public List<?> getAllListOfTouristToFlight() {
        return repository.findAll();
    }

    /* GET ALL TOURIST FLIGHTS */
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

    /* GET ALL TOURIST TO FLIGHT */
    @GetMapping("/touristsListOfFlights/flight_id/{id}")
    public Set<?> getAllTouristToFlight(@PathVariable(value = "id") Long flightID) {
        Set<Tourist> touristList = new HashSet<>();

        for(ListOfTouristToFlight list : repository.findAll()) {
            if(list.getFlightID().equals(flightID)) {
                touristList.add(touristRepository.findById(list.getTouristID()).get());
            }
        }
        return touristList;
    }

    /* ADDING A TOURIST TO THE FLIGHT */
    @PostMapping("/touristListToFlight")
    public ResponseEntity<ListOfTouristToFlight> addTouristToFlight(
           @Valid @RequestBody ListOfTouristToFlight listOfTouristToFlight
    ) {
        for(ListOfTouristToFlight a : repository.findAll()) {

            /* CHECKING IF THERE IS A  */
            if(a.getFlightID().equals(listOfTouristToFlight.getFlightID()) && a.getTouristID().equals(listOfTouristToFlight.getTouristID())) {
                return new ResponseEntity("There is already such a reservation", HttpStatus.BAD_REQUEST);
            }

            Long flightID = listOfTouristToFlight.getFlightID();
            Long touristID = listOfTouristToFlight.getTouristID();

            /* CHECKING IF THERE IS A FLIGHT WITH THE GIVEN ID */
            if(!flightRepository.findById(flightID).isPresent()) {
                return new ResponseEntity("There is no flight with the given id.", HttpStatus.BAD_REQUEST);
            }

            /* CHECKING IF THERE IS A TOURIST WITH THE FIVEN ID */
            else if(!touristRepository.findById(touristID).isPresent()) {
                System.out.println("Turysta o podanym id " + touristID + " nie istnieje");
                return new ResponseEntity("There is no tourist with the given identifier", HttpStatus.BAD_REQUEST);
            }
        }

        Long flightID = listOfTouristToFlight.getFlightID();

        Long numberOfSeats = flightRepository.findById(flightID).get().getNumberOfSeats();

        /* CHECKING IF THERE IS A FREE SEAT */
        if(numberOfSeats >= 1){
            flightRepository.findById(flightID).get().setNumberOfSeats(--numberOfSeats);

        }else {
            new ResourceNotFoundException("There are no vacancies");
            return new ResponseEntity("There are no vacancies.", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(repository.save(listOfTouristToFlight));
    }

}
