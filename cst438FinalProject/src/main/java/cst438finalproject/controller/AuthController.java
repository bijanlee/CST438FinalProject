package cst438finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cst438finalproject.domain.User;
import cst438finalproject.domain.UserRepository;

@Controller
public class AuthController {
    @Autowired
    private UserRepository repo;

   @GetMapping("/login")
   public String Login(Model model) {
      return "login";
   }
   
   @GetMapping("/register")
   public String Register(Model model) {
      model.addAttribute("user", new User());
      return "register";
   }
   
   @PostMapping("/success_register")
   public String successRegister(User user) {
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String encodedPassword = passwordEncoder.encode(user.getPasswd());
       user.setPasswd(encodedPassword);
        
       repo.save(user);
        
       return "success_register";
   }
   
   @GetMapping("/users")
   public String listUsers(Model model) {
       List<User> listUsers = repo.findAll();
       model.addAttribute("listUsers", listUsers);
        
       return "users";
   }
   
}
