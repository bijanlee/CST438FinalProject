package cst438finalproject.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cst438finalproject.domain.Car;
import cst438finalproject.domain.CarType;
import cst438finalproject.domain.CustomUserDetails;
import cst438finalproject.domain.Flight;
import cst438finalproject.domain.Hotel;
import cst438finalproject.domain.HotelReservation;
import cst438finalproject.domain.Location;
import cst438finalproject.domain.TravelPackageRepository;
import cst438finalproject.domain.TravelPackageViewModel;
import cst438finalproject.domain.TravelPackage;
import cst438finalproject.service.CarService;
import cst438finalproject.service.FlightService;
import cst438finalproject.service.HotelService;
import cst438finalproject.domain.User;
import cst438finalproject.domain.UserRepository;
import cst438finalproject.service.MockRequestService;
import java.security.Principal;

@Controller
public class HomeController {
   
   @Autowired
   MockRequestService mockRequestService;
   
   @Autowired
   HotelService hotelService;
   
   @Autowired
   CarService carService;
   
   @Autowired
   FlightService flightService;
   
   @Autowired(required=true)
   private HttpServletRequest request;
   
   @Autowired
   private TravelPackageRepository travelPackageRepository;
  
   private UserRepository repo;
   
  
   private Principal principal;

   @GetMapping("/home")
   public String Home(Model model) {
      return "index";
   }
   
   @GetMapping("/profile")
   public String Profile(Model model) {
      
     //System.out.println(principal);
      
      CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      int id = user.getId();
     
      List<TravelPackage> travelPackages = travelPackageRepository.findAllTravelPackagesByUserId(id);
      
      //model.addAttribute("packages", travelPackages);
      
      List<TravelPackageViewModel> viewModels = new ArrayList<TravelPackageViewModel>();
      
      for (TravelPackage tp : travelPackages) {
         Hotel hotel = hotelService.getHotel(tp.getHotelId());
         Flight flight = flightService.getFlight(tp.getFlightId());
         Car car = carService.getCar(tp.getCarId());
         int packageId = tp.getPackage_id();
         TravelPackageViewModel viewModel = new TravelPackageViewModel(hotel, flight, car, packageId);
         viewModels.add(viewModel);
      }
      
      model.addAttribute("viewModels", viewModels);
      
      model.addAttribute("currentUser", principal);
      
      return "profile";
   }
   
   @GetMapping("/cart")
   public String Cart(Model model) {
      return "cart";
   }
   
   @GetMapping("/hotels")
   public String Hotels(Model model) {
      return "hotels";
   }
   
   /*
    * @GetMapping("/SearchFlights") public String SearchFlights(Model model) {
    * List<Flight> flights = mockRequestService.getMockFlightData();
    * model.addAttribute("flights", flights);
    * 
    * return "search-flights"; }
    */
   
   @PostMapping("/SearchFlights")
   public String SearchFlightsPost(@RequestParam("city") String city, Model model) {
      List<Flight> flights = flightService.getFlights();
      model.addAttribute("flights", flights);
      
      model.addAttribute("City", "Test");
      
      return "search-flights";
   }
   
   @GetMapping("/BookFlight")
   public String BookFlightPost(@RequestParam("id") String flightId, Model model) {
      //save to cookie
      HttpSession session = request.getSession(true);
      session.setAttribute("flightId", flightId);
      
      //get car locations
      //List<Location> locations = carService.getLocations();
      //model.addAttribute("locations", locations);
      return "car-dates";
   }
   
   @PostMapping("/SearchHotels")
   public String SearchHotelsPost(@RequestParam("city") String city, @RequestParam("startDate") String startDate,
         @RequestParam("endDate") String endDate, Model model) {
      
      model.addAttribute("city", city);
      
      HttpSession session = request.getSession(true);
      session.setAttribute("startDate", startDate);
      session.setAttribute("endDate", endDate);
      
      //System.out.println(startDate.toString());
      
      
      //store start date and end date in cookie
      
      List<Hotel> hotels = hotelService.getHotels(city);
      model.addAttribute("hotels", hotels);
      return "search-hotels";
   }
   
   @GetMapping("/SearchHotels")
   public String SearchHotels(Model model) {
      //List<Hotel> hotels = mockRequestService.getMockHotelData();
      //model.addAttribute("hotels", hotels);
      
      return "search-hotels";
   }
   
   @GetMapping("/BookHotel")
   public String BookHotelPost(@RequestParam("id") int hotelId, Model model) {
      HttpSession session = request.getSession(true);
      session.setAttribute("hotelId", hotelId);
      
      List<Flight> flights = flightService.getFlights();
      model.addAttribute("flights", flights);
      
      return "search-flights";
      
      //return "flights";
   }
   
   /*
    * @GetMapping("SearchCars") public String SearchCars(Model model) { List<Car>
    * cars = mockRequestService.getMockCarData(); model.addAttribute("cars", cars);
    * 
    * return "search-cars"; }
    */
   
   @PostMapping("SearchCarLocations")
   public String SearchCarLocations(@RequestParam("startDate") String startDate,
         @RequestParam("endDate") String endDate, Model model) {
      
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
      LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
      LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);
      
      //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      //Date date = (Date)formatter.parse(startDate);
      
      String formattedStartDate = startDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      String formattedEndDate = endDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      
      HttpSession session = request.getSession(true);
      
      session.setAttribute("carStartDate", formattedStartDate);
      session.setAttribute("carEndDate", formattedEndDate);
      
      List<Location> locations = carService.getLocations();
      model.addAttribute("locations", locations);
      return "car-locations";
      
   }
   
   @GetMapping("SearchCarTypes")
   public String SearchCarTypes(@RequestParam("locationId") int locationId, Model model) {
      HttpSession session = request.getSession(true);
      session.setAttribute("locationId", locationId);
      
      List<CarType> carTypes = carService.getCarTypes(locationId);
      
      model.addAttribute("carTypes", carTypes);
      model.addAttribute("locationId", locationId);
      
      return "car-types";
   }
   
   @GetMapping("SearchCars")
   public String SearchCars(@RequestParam("locationId") int locationId, @RequestParam("carTypeId") int carTypeId, @RequestParam("price") double price, Model model) {
      List<Car> cars = carService.getCars(carTypeId, locationId);
      
      model.addAttribute("cars", cars);
      model.addAttribute("price", price);
      
      return "search-cars";
   }
   
   @GetMapping("/BookCar")
   public String BookCar(@RequestParam("id") int carId, Model model) {
      
      HttpSession session = request.getSession(true);
      session.setAttribute("carId", carId);
      String startDate = (String) session.getAttribute("startDate");
      String endDate = (String) session.getAttribute("endDate");
      
      String flightId = (String) session.getAttribute("flightId");
      int hotelId = (int) session.getAttribute("hotelId");
      
      model.addAttribute("startDate", startDate);
      model.addAttribute("endDate", endDate);
      
      Car car = carService.getCar(carId);
      Flight flight = flightService.getFlight(flightId);
      Hotel hotel = hotelService.getHotel(hotelId);
      
      model.addAttribute("car", car);
      model.addAttribute("flight", flight);
      model.addAttribute("hotel", hotel);
      
      
      return "package-book";
   }
   
   @GetMapping("/Confirm")
   public String Confirm(Model model) {
      HttpSession session = request.getSession(true);
      
      String startDate = (String) session.getAttribute("startDate");
      String endDate = (String) session.getAttribute("endDate");
      
      String carStartDate = (String) session.getAttribute("carStartDate");
      String carEndDate = (String) session.getAttribute("carEndDate");
      
      int locationId = (int) session.getAttribute("locationId");
      
      int hotelId = (int) session.getAttribute("hotelId");
      String flightId = (String) session.getAttribute("flightId");
      int carId = (int) session.getAttribute("carId");
      
      HotelReservation hotelReservation = hotelService.reserveHotel(hotelId, startDate, endDate);
      int hotelReservationId = hotelReservation.getId();
      int flightReservationId = flightService.reserveFlight(flightId);
      int carReservationId = carService.reserveCar(carId, carStartDate, carEndDate, locationId);
      
      CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      int id = user.getId();
      
      //save to package table
      int itenary_number = 100;
      
      //Package _package = new Package();
      
      TravelPackage travelPackage = new TravelPackage(id, itenary_number, hotelId, flightId, carId, hotelReservationId, flightReservationId, carReservationId);
      
      travelPackageRepository.save(travelPackage);
      
      return "confirm";
   }
   
   @GetMapping("/Cancel")
   public String Cancel(@RequestParam("id") int packageId, Model model) {
      
      List<TravelPackage> travelPackages = travelPackageRepository.findByPackageId(packageId);
      TravelPackage travelPackage = travelPackages.get(0);
      
      int hotelReservationId = travelPackage.getHotelReservationId();
      int flightReservationId = travelPackage.getFlightReservationId();
      int carReservationId = travelPackage.getCarReservationId();
      
      travelPackageRepository.deletePackageById(packageId);
      
      hotelService.cancelHotelReservation(hotelReservationId);
      flightService.cancelFlightReservation(flightReservationId);
      carService.cancelCarReservation(carReservationId);
      
      return "cancel";
   }
   
}
