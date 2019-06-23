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

    private Long flightID;

    private Long touristID;

    //SETTERS AND GETTERS

    //SETTER AND GETTER ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //SETTER AND GETTER FLIGHT ID
    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    //SETTER AND GETTER TOURIST ID
    public Long getTouristID() {
        return touristID;
    }

    public void setTouristID(Long touristID) {
        this.touristID = touristID;
    }
}
