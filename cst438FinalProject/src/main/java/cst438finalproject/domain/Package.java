package cst438finalproject.domain;
import cst438finalproject.domain.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="packages")
public class Package {
    @Id
    private int package_id;
    private int user_id;
    private int itenary_number;
    private int hotel_id;
    private int flight_id;
    private int car_id;
    private int hotel_reservation_id;
    private int flight_reservation_id;
    private int car_reservation_id;
    
    
    public Package() { }
    
    public Package(int user_id, int itenary_number, int hotel_id, int flight_id, int car_id, int hotel_reservation_id,
          int flight_reservation_id, int car_reservation_id) {
        this.user_id = user_id;
        this.itenary_number = itenary_number;
        this.hotel_id = hotel_id;
        this.flight_id = flight_id;
        this.car_id = car_id;
        this.hotel_reservation_id = hotel_reservation_id;
        this.flight_reservation_id = flight_reservation_id;
        this.car_reservation_id = car_reservation_id;
    }
    

    
    
    public int getHotelId() { 
        return this.hotel_id;
    }
    
    public void setHotel(int hotel_id) { 
        this.hotel_id = hotel_id;
    }
    
    public int getFlightId() { 
        return this.flight_id;
    }
    
    public void setFlight(int flight_id) {
        this.flight_id = flight_id;
    }
    
    public int getCarId() {
       return this.car_id;
    }
    
    public void setCarId(int car_id) {
       this.car_id = car_id;
    }
    
    public int getHotelReservationId() {
       return this.hotel_reservation_id;
    }
    
    public void setHotelReservationId(int hotel_reservation_id) {
       this.hotel_reservation_id = hotel_reservation_id;
    }
    
    public int getFlightReservationId() {
       return this.flight_reservation_id;
    }
    
    public void setFlightReservationId(int car_id) {
       this.car_id = flight_reservation_id;
    }
    
    public int getCarReservationId() {
       return this.car_reservation_id;
    }
    
    public void setCarReservationId(int car_id) {
       this.car_reservation_id = car_id;
    }
    
    
    public int getUserId() {
        return this.user_id;
    }
    
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

}
