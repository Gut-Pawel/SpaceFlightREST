package eu.treative.spaceTouristFlights.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;


@Entity
@Table(name = "flights")
@EntityListeners(AuditingEntityListener.class)
public class Flight {

    public Flight() {

    }

    private long id;

    //a. Departure date
    private java.sql.Date deparatureDate;

    //a2. Deparature time
    private java.sql.Time deparatureTime;

    //b. Arrival date
    private java.sql.Date arrivalDate;

    //b2. Arrival time
    private java.sql.Time arrivalTime;

    //c. Number of seats
    private long numberOfSeats;

    //d. List of tourists

    //List of tourist is on separate table(name = list_of_tourist_to_flight

    //e. Ticket price
    private float price;

    //SETTERS AND GETTERS

    //SETTER AND GETTER ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //SETTER AND GETTER DEPARATURE DATE

    public void setDeparatureDate(java.sql.Date deparature) {
        this.deparatureDate = deparature;
    }

    public java.sql.Date getDeparatureDate() {
        return deparatureDate;
    }

    //SETTER AND GETTER DEPARATURE TIME

    public void setDeparatureTime(Time deparatureTime) {
        this.deparatureTime = deparatureTime;
    }

    public Time getDeparatureTime() {
        return deparatureTime;
    }

    //SETTER AND GETTER ARRIVAL DATE

    public java.sql.Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(java.sql.Date arrival) {
        this.arrivalDate = arrival;
    }

    //SETTER AND GETTER ARRIVAL TIME

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    //SETTER AND GETTER NUMBER OF SEATS

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    //SETTER AND GETTER PRICE

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
