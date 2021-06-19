package cst438finalproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cst438finalproject.domain.Hotel;
import cst438finalproject.service.HotelService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class HotelServiceTest
{
   
   @Autowired
   private HotelService hotelService;
   
   @Mock
   private RestTemplate restTemplate;
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
   }
   
   @Test
   public void test1() throws Exception, JsonProcessingException {
      int id = 1;
      
      //String json = "{\"id\":1,\"name\":}";
      
      ObjectMapper mapper = new ObjectMapper();
      
      Hotel hotel = new Hotel(1, "Holiday Inn", 100, "123 Main St", 4, "New York");
      String json = mapper.writeValueAsString(hotel);
      
      JsonNode jsonNode = mapper.readTree(json);
      
      HttpHeaders header = new HttpHeaders();
      header.setContentType(MediaType.APPLICATION_JSON);
      
      ResponseEntity<JsonNode> response = new ResponseEntity<JsonNode>(jsonNode, header, HttpStatus.OK);
      
      String url = hotelService.hotelUrl + "/hotel/" + id;
      Mockito
      .when(restTemplate.getForEntity(url, JsonNode.class))
      .thenReturn(response);
      
      Hotel hotelResult = hotelService.getHotel(id);
      assertThat(hotelResult.getName()).isEqualTo("Holiday Inn");
      
   }
   
   @Test
   public void test2() throws Exception, JsonProcessingException {
      
      String search = "test";
      
      ObjectMapper mapper = new ObjectMapper();
      
      Hotel hotel = new Hotel(1, "Holiday Inn", 100, "123 Main St", 4, "New York");
      Hotel hotel2 = new Hotel(1, "Holiday Inn2", 100, "123 Main St", 4, "New York");
      Hotel hotel3 = new Hotel(1, "Holiday Inn3", 100, "123 Main St", 4, "New York");
      Hotel hotel4 = new Hotel(1, "Holiday Inn4", 100, "123 Main St", 4, "New York");
      String json = mapper.writeValueAsString(hotel);
      String json2 = mapper.writeValueAsString(hotel2);
      String json3 = mapper.writeValueAsString(hotel3);
      String json4 = mapper.writeValueAsString(hotel4);
      
      JsonNode jsonNode = mapper.readTree(json);
      JsonNode jsonNode2 = mapper.readTree(json2);
      JsonNode jsonNode3 = mapper.readTree(json3);
      JsonNode jsonNode4 = mapper.readTree(json4);
      
      JsonNode[] jsonNodes = new JsonNode[] {
            jsonNode, jsonNode2, jsonNode3, jsonNode4
      };
      
      HttpHeaders header = new HttpHeaders();
      header.setContentType(MediaType.APPLICATION_JSON);
      
      ResponseEntity<JsonNode[]> response = new ResponseEntity<JsonNode[]>(jsonNodes, header, HttpStatus.OK);
      
      String url = hotelService.hotelUrl + "/hotels/" + search;
      Mockito
      .when(restTemplate.getForEntity(url, JsonNode[].class))
      .thenReturn(response);
      
      List<Hotel> hotelResults = hotelService.getHotels(search);
      assertThat(hotelResults.size()).isEqualTo(4);
   }
}
