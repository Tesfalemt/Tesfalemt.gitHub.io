package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}



	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "Roller_USER"));
			userService.saveRole(new Role(null, "Roller_MANAGER"));
			userService.saveRole(new Role(null, "Roller_ADMIN"));
			userService.saveRole(new Role(null, "Roller_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));

			userService.saveUser(new User(null, "Arnode Schwarzeneger", "arnold", "1234", new ArrayList<>()));


			userService.addRoleUser("john", "Roller_USER");
			userService.addRoleUser("will", "Roller_MANAGER");
			userService.addRoleUser("jim", "Roller_ADMIN");
			userService.addRoleUser("arnold", "Roller_SUPER_ADMIN");
			userService.addRoleUser("arnold", "Roller_ADMIN");
			userService.addRoleUser("arnold", "Roller_USER");

		};
	}

}

