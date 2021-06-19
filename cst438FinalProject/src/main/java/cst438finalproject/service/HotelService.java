package cst438finalproject.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import cst438finalproject.domain.Hotel;
import cst438finalproject.domain.HotelReservation;
import cst438finalproject.domain.HotelReservationPostModel;

@Service
public class HotelService
{
   private static final Logger log = LoggerFactory.getLogger(HotelService.class);
   
   @Autowired
   private RestTemplate restTemplate;
   
   public String hotelUrl;
   
   public HotelService(
         @Value("${hotel.url}") final String hotelUrl)
   {
      //this.restTemplate = new RestTemplate();
      this.hotelUrl = hotelUrl;
   }
   
   @Bean
   public RestTemplate restTemplate() {
      return new RestTemplate();
   }
   
   public Hotel getHotel(int id) {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(
            hotelUrl + "/hotel/" + id, JsonNode.class);
      log.info("Status code from hotel server:" + response.getStatusCodeValue());
      
      JsonNode node = response.getBody();
      int hotelId = node.get("id").asInt();
      String name = node.get("name").asText();
      String address = node.get("address").asText();
      String city = node.get("city").asText();
      int stars = node.get("stars").asInt();
      int price = node.get("price").asInt();
      Hotel hotel = new Hotel(hotelId, name, price, address, stars, city);
      
      return hotel;
   }
   
   public List<Hotel> getHotels (String cityName) {
      ResponseEntity<JsonNode[]> response = restTemplate.getForEntity(
            hotelUrl + "/hotels/" + cityName,
            JsonNode[].class);
      log.info("Status code from hotel server:" + response.getStatusCodeValue());
     
      List<Hotel> hotels = new ArrayList<Hotel>();
       
      JsonNode[] nodes = response.getBody();
      for (JsonNode node : nodes) {
         int id = node.get("id").asInt();
         String name = node.get("name").asText();
         String address = node.get("address").asText();
         String city = node.get("city").asText();
         int stars = node.get("stars").asInt();
         int price = node.get("price").asInt();
         Hotel hotel = new Hotel(id, name, price, address, stars, city);
         hotels.add(hotel);
      }
      
      return hotels;
   }
   
   public HotelReservation reserveHotel (int hotelId, String startDate, String endDate) {
      
      /*
       * DateTimeFormatter formatter =
       * DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm"); LocalDateTime startDt =
       * LocalDateTime.parse(startDate, formatter); LocalDateTime endDt =
       * LocalDateTime.parse(endDate, formatter);
       * 
       * DateTimeFormatter hotelFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       * String formattedStartDate = startDt.format(hotelFormatter); String
       * formattedEndDate = endDt.format(hotelFormatter);
       */
      
      HotelReservationPostModel hotelReservationPostModel = new HotelReservationPostModel(hotelId, "double",
            startDate, endDate);
      
      ResponseEntity<JsonNode> response = restTemplate.postForEntity(
            hotelUrl + "/reservations", hotelReservationPostModel, JsonNode.class);
      log.info("Status code from hotel server:" + response.getStatusCodeValue());
      
      JsonNode node = response.getBody();
      
      int id = node.get("id").asInt();
      int hotel_Id = node.get("hotelId").asInt();
      String roomtype = node.get("roomtype").asText();
      String startdate = node.get("startdate").asText();
      String enddate = node.get("enddate").asText();
      
      HotelReservation hotelReservation = new HotelReservation(id, hotel_Id, roomtype, startdate, enddate);
      return hotelReservation;
   }
   
   public void cancelHotelReservation(int hotelReservation) {
      
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      
      String url = hotelUrl + "/reservations/{id}";
      HttpEntity<?> httpEntity = new HttpEntity<>(headers);
      Integer id = hotelReservation;
      
      ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE,
            httpEntity, Void.class, id);
      
      System.out.println("Status Code: " + responseEntity.getStatusCodeValue());
      
   }
   
}
