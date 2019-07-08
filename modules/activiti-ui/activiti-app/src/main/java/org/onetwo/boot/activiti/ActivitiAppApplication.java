package org.onetwo.boot.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude={LiquibaseAutoConfiguration.class,
								SecurityFilterAutoConfiguration.class})
@RestController
public class ActivitiAppApplication {

	/*@GetMapping("/")
	public String index() {
		return "up";
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(ActivitiAppApplication.class, args);
	}

}
