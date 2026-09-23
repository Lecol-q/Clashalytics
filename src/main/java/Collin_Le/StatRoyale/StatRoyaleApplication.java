package Collin_Le.StatRoyale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StatRoyaleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StatRoyaleApplication.class, args);

		Player player = applicationContext.getBean(Player.class);
		player.displayStats();

	}

}
