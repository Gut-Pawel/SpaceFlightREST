package eu.treative.spaceTouristFlights.repository;

import eu.treative.spaceTouristFlights.models.ListOfTouristToFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOfTouristToFlightRepository extends JpaRepository<ListOfTouristToFlight, Long> {

}
