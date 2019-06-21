package eu.treative.spaceTouristFlights.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "list_of_tourist_to_flight")
@EntityListeners(AuditingEntityListener.class)
public class ListOfTouristToFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Long flightID;

    private Long touristID;

    public Long getFlightID() {
        return flightID;
    }

    public Long getTouristID() {
        return touristID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public void setTouristID(Long touristID) {
        this.touristID = touristID;
    }
}
