package cst438finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{

   @GetMapping("/home")
   public String Home(Model model) {
      return "index";
   }
   
   @GetMapping("/SearchFlights")
   public String SearchFlights(Model model) {
      return "search-flights";
   }
   
   @GetMapping("/SearchHotels")
   public String SearchHotels(Model model) {
      return "search-hotels";
   }
   
   @GetMapping("SearchCars")
   public String SearchCars(Model model) {
      return "search-cars";
   }
   
}
