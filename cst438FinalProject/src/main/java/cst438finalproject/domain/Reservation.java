package cst438finalproject.domain;
import cst438finalproject.domain.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import java.util.Date;
import javax.persistence.ManyToOne;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    private int ID;
    private String hotel;
    private String flight;
    private String carRental;
    private Date dateTime;
    
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName="userID")
    private User user;
    
    public Reservation() { }
    
    public Reservation(int ID, String hotel, String flight, String carRental, Date dateTime, User user) {
        this.ID = ID;
        this.hotel = hotel;
        this.flight = flight;
        this.carRental = carRental;
        this.dateTime = dateTime;
        this.user = user;
    }
    
    public int getID() { 
        return this.ID;
    }
    
    public void setId(int ID) {
        this.ID = ID;
    }
    
    public String getHotel() { 
        return this.hotel;
    }
    
    public void setHotel(String hotel) { 
        this.hotel = hotel;
    }
    
    public String getFlight() { 
        return this.flight;
    }
    
    public void setFlight(String flight) {
        this.flight = flight;
    }
    
    public Date getDate() {
        return this.dateTime;
    }
    
    public void setDate(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setDate(User user) {
        this.user = user;
    }

}
