package Collin_Le.StatRoyale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class StatRoyaleApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(StatRoyaleApplication.class, args);

		Player player = applicationContext.getBean(Player.class);
		API api = applicationContext.getBean(API.class);
		player.displayStats();

	}

}
