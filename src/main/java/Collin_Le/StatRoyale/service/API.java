package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.config.Config;
import Collin_Le.StatRoyale.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.ObjectMapper;

@Component
public class API {
    public Player player;
    public Card card;
    Chest chest;
    String apiKey = Config.getKey("CLASH_ROYALE_API_KEY");
    String base_url = Config.getURL("BASE_URL");
    //String tag = "#U9JP0JVR";

    // List Objects
    Items items;
    ChestList chests;

    private static ObjectMapper objectMapper = new ObjectMapper();

    RestClient restClient = RestClient.builder()
            .baseUrl(base_url)
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .requestInterceptor((request, body, execution) -> {
                System.out.println(request.getURI());
                return execution.execute(request, body);
            })
            .build();

    public Player requestPlayerStats(String tag) {
        try {
            player = objectMapper.readValue(restClient.get().uri("/players/{playerTag}", tag).retrieve().body(String.class), Player.class);
            player.displayPlayerStats();
            return player;
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
            return null;
        }
    }

    public void requestCardStats() {
        try {
            items = objectMapper.readValue(restClient.get().uri("/cards?limit=5").retrieve().body(String.class), Items.class);
            items.getCards();
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
        }
    }

    public void requestChests(String tag) {
        try {
            chests = objectMapper.readValue(restClient.get().uri("/players/{playerTag}/upcomingchests", tag).retrieve().body(String.class), ChestList.class);
            chests.getUpcomingChests();
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
        }
    }


}
