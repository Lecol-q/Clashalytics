package Collin_Le.StatRoyale;

import Collin_Le.StatRoyale.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import Collin_Le.StatRoyale.service.API;

import java.io.IOException;

@SpringBootApplication
public class StatRoyaleApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(StatRoyaleApplication.class, args);

		//Player player = applicationContext.getBean(Player.class);
		//Card card = applicationContext.getBean(Card.class);
		API api = applicationContext.getBean(API.class);
		Config config = applicationContext.getBean(Config.class);
	}
}
