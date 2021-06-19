package cst438finalproject;

import static org.assertj.core.api.Assertions.assertThat;

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

import cst438finalproject.domain.Car;
import cst438finalproject.domain.Hotel;
import cst438finalproject.service.CarService;
import cst438finalproject.service.HotelService;

@SpringBootTest
public class CarServiceTest
{

   @Autowired
   private CarService carService;
   
   @Mock
   private RestTemplate restTemplate;
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
   }
   
   @Test
   public void test1() throws Exception, JsonProcessingException {
      int carId = 1;
      
      ObjectMapper mapper = new ObjectMapper();
      Car car = new Car(1, "test", "test", "test", 1, "test", 1, 1);
      String json = mapper.writeValueAsString(car);
      
      JsonNode jsonNode = mapper.readTree(json);
      
      HttpHeaders header = new HttpHeaders();
      header.setContentType(MediaType.APPLICATION_JSON);
      
      ResponseEntity<JsonNode> response = new ResponseEntity<JsonNode>(jsonNode, header, HttpStatus.OK);
      //carUrl + "/car/" + carId, JsonNode.class
      String url = carService.carUrl + "/car/" + carId;
      Mockito
      .when(restTemplate.getForEntity(url, JsonNode.class))
      .thenReturn(response);
      
      Car carResult = carService.getCar(carId);
      assertThat(carResult.getBrand()).isEqualTo("test");
   }
}
