package cst438finalproject.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ReservationController {
    @GetMapping("/reservation")
    public String Reservation(Model model) {
       return "reservation";
    }
}
