package cst438finalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import cst438finalproject.domain.Car;
import cst438finalproject.domain.CarType;
import cst438finalproject.domain.Location;

@Service
public class CarService
{
   private static final Logger log = LoggerFactory.getLogger(HotelService.class);
   private RestTemplate restTemplate;
   private String carUrl;
   
   public CarService(
         @Value("${car.url}") final String carUrl)
   {
      this.restTemplate = new RestTemplate();
      this.carUrl = carUrl;
   }
   
   public List<Location> getLocations() {
      ResponseEntity<JsonNode[]> response = restTemplate.getForEntity(
            carUrl + "/locations", JsonNode[].class);
      log.info("Status code from car server:" + response.getStatusCodeValue());
      
      List<Location> locations = new ArrayList<Location>();
      
      JsonNode[] nodes = response.getBody();
      for (JsonNode node : nodes) {
         int id = node.get("id").asInt();
         String street = node.get("street").asText();
         String city = node.get("city").asText();
         String state = node.get("state").asText();
         String country = node.get("country").asText();
         int zipcode = node.get("zipcode").asInt();
         String phone = node.get("phone").asText();
         double tax = node.get("tax").asDouble();
         Location location = new Location(id, street, city, state, country, zipcode, phone, tax);
         locations.add(location);
      }
      
      return locations;
   }
   
   public List<CarType> getCarTypes(int locationId) {
      ResponseEntity<JsonNode[]> response = restTemplate.getForEntity(
            carUrl + "/cartypes/" + locationId, JsonNode[].class);
      
      log.info("Status code from car server:" + response.getStatusCodeValue());
      
      List<CarType> carTypes = new ArrayList<CarType>();
      
      JsonNode[] nodes = response.getBody();
      
      for (JsonNode node: nodes) {
         int id = node.get("id").asInt();
         String name = node.get("name").asText();
         int passengerCount = node.get("passengerCount").asInt();
         int airbagCount = node.get("airbagCount").asInt();
         String transmission = node.get("transmission").asText();
         double price = node.get("price").asDouble();
         String description = node.get("description").asText();
         CarType carType = new CarType(id, name, passengerCount, airbagCount, transmission, price, description);
         carTypes.add(carType);
      }
      
      return carTypes;
   }
   
   public List<Car> getCars(int carTypeId, int locationId) {
      ResponseEntity<JsonNode[]> response = restTemplate.getForEntity(
            carUrl + "/cars/" + carTypeId + "," + locationId, JsonNode[].class);
      
      log.info("Status code from car server:" + response.getStatusCodeValue());
      
      List<Car> cars = new ArrayList<Car>();
      
      JsonNode[] nodes = response.getBody();
      
      for (JsonNode node: nodes) {
         int id = node.get("id").asInt();
         String brand = node.get("brand").asText();
         String model = node.get("model").asText();
         String color = node.get("color").asText();
         int year = node.get("year").asInt();
         String description = node.get("description").asText();
         int _carTypeId = node.get("carTypeId").asInt();
         int _locationId = node.get("locationId").asInt();
         Car car = new Car(id, brand, model, color, year, description, _carTypeId, _locationId);
         cars.add(car);
      }
      
      
      return cars;
   }
   
   public Car getCar(int carId) {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(
            carUrl + "/car/" + carId, JsonNode.class);
      log.info("Status code from car server:" + response.getStatusCodeValue());
      
      JsonNode node = response.getBody();
      int id = node.get("id").asInt();
      String brand = node.get("brand").asText();
      String model = node.get("model").asText();
      String color = node.get("color").asText();
      int year = node.get("year").asInt();
      String description = node.get("description").asText();
      int _carTypeId = node.get("carTypeId").asInt();
      int _locationId = node.get("locationId").asInt();
      Car car = new Car(id, brand, model, color, year, description, _carTypeId, _locationId);
      
      return car;
   }
   
}
