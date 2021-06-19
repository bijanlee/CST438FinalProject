package cst438finalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import cst438finalproject.domain.Flight;
import cst438finalproject.domain.PassengerPostModel;

@Service
public class FlightService
{
   private static final Logger log = LoggerFactory.getLogger(FlightService.class);
   
   @Autowired
   private RestTemplate restTemplate;
   
   public String flightUrl;
   
   public FlightService(
         @Value("${flight.url}") final String flightUrl)
   {
      //this.restTemplate = new RestTemplate();
      this.flightUrl = flightUrl;
   }
   
   public Flight getFlight(String id) {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(
            flightUrl + "/flights/flight/" + id, JsonNode.class);
      log.info("Status code from flight server:" + response.getStatusCodeValue());
      
      JsonNode node = response.getBody();
      
      JsonNode flightNode = node.get("flight");
      
      String flightNum = flightNode.get("flightNum").asText();
      int airlineID = flightNode.get("airlineID").asInt();
      String leaveTime = flightNode.get("leaveTime").asText();
      String leaveDate = flightNode.get("leaveDate").asText();
      String arriveTime = flightNode.get("arriveTime").asText();
      String arriveDate = flightNode.get("arriveDate").asText();
      int price = flightNode.get("price").asInt();
      int numStops = flightNode.get("numStops").asInt();
      int seatsAvailable = flightNode.get("seatsAvailable").asInt();
      int originCity = flightNode.get("originCity").asInt();
      int destCity = flightNode.get("destCity").asInt();
      String originAirport = flightNode.get("originAirport").asText();
      String destAirport = flightNode.get("destAirport").asText();
      Flight flight = new Flight(flightNum, airlineID, leaveTime, leaveDate,
            arriveTime, arriveDate, price, numStops, seatsAvailable, originCity,
            destCity, originAirport, destAirport);
      
      return flight;
   }
   
   public List<Flight> getFlights () {
      ResponseEntity<JsonNode[]> response = restTemplate.getForEntity(
            flightUrl + "/flights/flight/all", JsonNode[].class);
      log.info("Status code from flight server:" + response.getStatusCodeValue());
      
      List<Flight> flights = new ArrayList<Flight>();
      
      JsonNode[] nodes = response.getBody();
      for (JsonNode node : nodes) {
         String flightNum = node.get("flightNum").asText();
         int airlineID = node.get("airlineID").asInt();
         String leaveTime = node.get("leaveTime").asText();
         String leaveDate = node.get("leaveDate").asText();
         String arriveTime = node.get("arriveTime").asText();
         String arriveDate = node.get("arriveDate").asText();
         int price = node.get("price").asInt();
         int numStops = node.get("numStops").asInt();
         int seatsAvailable = node.get("seatsAvailable").asInt();
         int originCity = node.get("originCity").asInt();
         int destCity = node.get("destCity").asInt();
         String originAirport = node.get("originAirport").asText();
         String destAirport = node.get("destAirport").asText();
         
         Flight flight = new Flight(flightNum, airlineID, leaveTime, leaveDate,
               arriveTime, arriveDate, price, numStops, seatsAvailable, originCity,
               destCity, originAirport, destAirport);
         
         flights.add(flight);
      }
      
      return flights;
   }
   
   public int reserveFlight(String flightId) {
      
      PassengerPostModel passengerPostModel = new PassengerPostModel("test", "name", flightId);
      
      ResponseEntity<String> response = restTemplate.postForEntity(
            flightUrl + "/flights/passenger/", passengerPostModel, String.class);
      log.info("Status code from hotel server:" + response.getStatusCodeValue());
      
      String body = response.getBody();
      
      int id = Integer.parseInt(body);
      
      return id;
   }
   
   public void cancelFlightReservation(int flightReservationId) {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      
      String url = flightUrl + "/flights/passenger/{id}";
      
      HttpEntity<?> httpEntity = new HttpEntity<>(headers);
      Integer id = flightReservationId;
      
      ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE,
            httpEntity, Void.class, id);
      
      System.out.println("Status Code: " + responseEntity.getStatusCodeValue());
      
   }

}
