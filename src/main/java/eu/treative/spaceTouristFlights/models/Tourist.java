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

    //SETTERS AND GETTERS

    //SETTER AND GETTER ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //SETTER AND GETTER FIRST NAME
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //SETTER AND GETTER LAST NAME
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //SETTER AND GETTER GENDER( MALE OR FEMALE )
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //SETTER AND GETTER COUNTRY
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //GETTER AND SETTER DATE OF BIRTH
    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //SETTER AND GETTER REMARKS
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
