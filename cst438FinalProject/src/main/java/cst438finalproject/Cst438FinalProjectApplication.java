package cst438finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Cst438FinalProjectApplication {
   
	public static void main(String[] args) {
		SpringApplication.run(Cst438FinalProjectApplication.class, args);
	}

}
