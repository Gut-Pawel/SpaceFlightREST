package eu.treative.spaceTouristFlights.repository;

import eu.treative.spaceTouristFlights.models.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {


}
