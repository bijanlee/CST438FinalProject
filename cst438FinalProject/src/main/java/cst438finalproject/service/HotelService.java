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

import cst438finalproject.domain.Hotel;

@Service
public class HotelService
{
   private static final Logger log = LoggerFactory.getLogger(HotelService.class);
   private RestTemplate restTemplate;
   private String hotelUrl;
   
   public HotelService(
         @Value("${hotel.url}") final String hotelUrl)
   {
      this.restTemplate = new RestTemplate();
      this.hotelUrl = hotelUrl;
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
}
