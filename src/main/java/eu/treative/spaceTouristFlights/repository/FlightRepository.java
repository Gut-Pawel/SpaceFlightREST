package eu.treative.spaceTouristFlights.repository;

import eu.treative.spaceTouristFlights.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


}
