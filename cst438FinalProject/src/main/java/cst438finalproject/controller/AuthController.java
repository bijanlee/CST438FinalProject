package cst438finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController
{

   @GetMapping("Login")
   public String Login(Model model) {
      return "login";
   }
   
   @GetMapping("Register")
   public String Register(Model model) {
      return "register";
   }
   
}
