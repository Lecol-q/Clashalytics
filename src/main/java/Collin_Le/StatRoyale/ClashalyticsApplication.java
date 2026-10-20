package Collin_Le.StatRoyale;

import Collin_Le.StatRoyale.config.Config;
import Collin_Le.StatRoyale.config.SecurityConfig;
import Collin_Le.StatRoyale.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import Collin_Le.StatRoyale.service.API;

import java.io.IOException;

@SpringBootApplication
public class ClashalyticsApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(ClashalyticsApplication.class, args);

		API api = applicationContext.getBean(API.class);
		Config config = applicationContext.getBean(Config.class);
		SecurityConfig securityConfig = applicationContext.getBean(SecurityConfig.class);
		UserService userService = applicationContext.getBean(UserService.class);
	}
}
