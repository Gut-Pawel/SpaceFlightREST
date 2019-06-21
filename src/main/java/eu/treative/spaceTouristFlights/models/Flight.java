package eu.treative.spaceTouristFlights.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "flights")
@EntityListeners(AuditingEntityListener.class)
public class Flight {

    public Flight() {

    }

    private long id;

    //a. Departure date and time
    private java.sql.Date deparature;

    //b. Arrival date and time
    private java.sql.Date arrival;

    //c. Number of seats
    private long numberOfSeats;

    //d. List of tourists

    //@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    /*@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "id", joinColumns = @JoinColumn(name = "flight_ID") )
    @Column(name = "tourist_id")
    private Set<Long> listOfTourist = new HashSet<Long>();*/

    //e. Ticket price
    private float price;

    //SETTERS AND GETTERS

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDeparature(java.sql.Date deparature) {
        this.deparature = deparature;
    }

    public java.sql.Date getDeparature() {
        return deparature;
    }

    public java.sql.Date getArrival() {
        return arrival;
    }

    public void setArrival(java.sql.Date arrival) {
        this.arrival = arrival;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /* List of flights */

    /*
    @ElementCollection
    //@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "tourist_id")
    public Set<Long> getListOfTourist() {

        return listOfTourist;
    }

    @ElementCollection
    public Set<Long> getListOfTourist(Long touristID) {
        this.getListOfTourist().add(touristID);
        listOfTourist.add(touristID);
        return listOfTourist;
    }

    @ElementCollection
    public void setListOfTourist(Set<Long> touristID) {
        this.listOfTourist = listOfTourist;
    }

    @ElementCollection
    public void addTouristToList(Long touristID) {
        listOfTourist.add(touristID);
    }*/

}
