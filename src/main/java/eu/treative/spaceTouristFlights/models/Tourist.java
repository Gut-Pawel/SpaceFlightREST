package eu.treative.spaceTouristFlights.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tourists")
@EntityListeners(AuditingEntityListener.class)
public class Tourist {

    private Long id;

    //a. First name
    private String firstName;

    //b. Last name
    private String lastName;

    //c. Gender
    private String gender;

    //d. Country
    private String country;

    //e. Remarks
    private String remarks;

    //f. Date of birth
    private java.sql.Date dateOfBirth;

    //g. List of flights
    //https://stackoverflow.com/questions/5867130/hibernate-liststring
    /*@ElementCollection
    private List<Long> listOfFlights = new ArrayList<>();*/

    //SETTERS AND GETTERS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    /*@org.hibernate.annotations.CollectionId(columns = "")
    @Column(name = "List_of_flights")
    public List<Long> getListOfFlights() {
        return listOfFlights;
    }

    public void addFlight(Long idFlight) {
        this.listOfFlights.add(idFlight);
    }*/


}
