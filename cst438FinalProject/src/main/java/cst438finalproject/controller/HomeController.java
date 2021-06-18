package cst438finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cst438finalproject.domain.Car;
import cst438finalproject.domain.Flight;
import cst438finalproject.domain.Hotel;
import cst438finalproject.domain.User;
import cst438finalproject.domain.UserRepository;
import cst438finalproject.service.MockRequestService;
import java.security.Principal;

@Controller
public class HomeController {
   
   @Autowired
   MockRequestService mockRequestService;
   
   @Autowired
   private UserRepository repo;
   
  
   private Principal principal;

   @GetMapping("/home")
   public String Home(Model model) {
      return "index";
   }
   
   @GetMapping("/profile")
   public String Profile(Model model) {
      
     System.out.println(principal);
     
      model.addAttribute("currentUser", principal);
      
      return "profile";
   }
   
   @GetMapping("/cart")
   public String Cart(Model model) {
      return "cart";
   }
   
   @GetMapping("/SearchFlights")
   public String SearchFlights(Model model) {
      List<Flight> flights = mockRequestService.getMockFlightData();
      model.addAttribute("flights", flights);
      
      return "search-flights";
   }
   
   @GetMapping("/SearchHotels")
   public String SearchHotels(Model model) {
      List<Hotel> hotels = mockRequestService.getMockHotelData();
      model.addAttribute("hotels", hotels);
      
      return "search-hotels";
   }
   
   @GetMapping("SearchCars")
   public String SearchCars(Model model) {
      List<Car> cars = mockRequestService.getMockCarData();
      model.addAttribute("cars", cars);
      
      return "search-cars";
   }
   
}
