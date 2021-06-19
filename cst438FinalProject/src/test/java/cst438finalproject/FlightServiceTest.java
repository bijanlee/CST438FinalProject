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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cst438finalproject.domain.Flight;
import cst438finalproject.service.FlightService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FlightServiceTest
{

   @Autowired
   private FlightService flightService;
   
   @Mock
   private RestTemplate restTemplate;
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
   }
   
   @Test
   public void test1() throws Exception, JsonProcessingException {
      String id = "test";
      
      ObjectMapper mapper = new ObjectMapper();
      
      Flight flight = new Flight("test", 1, "test", "test", "test", "test", 1, 1, 1, 1, 1, "test", "test");
      String json = mapper.writeValueAsString(flight);
      JsonNode jsonNode = mapper.readTree(json);
      
      HttpHeaders header = new HttpHeaders();
      header.setContentType(MediaType.APPLICATION_JSON);
      
      ResponseEntity<JsonNode> response = new ResponseEntity<JsonNode>(jsonNode, header, HttpStatus.OK);
      
      String url = flightService.flightUrl + "/flights/flight/" + id;
      Mockito
      .when(restTemplate.getForEntity(url, JsonNode.class))
      .thenReturn(response);
      
      Flight flightResult = flightService.getFlight(id);
      
      assertThat(flightResult.getFlightNum()).isEqualTo("test");
   }
   
}
