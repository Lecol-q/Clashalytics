package Collin_Le.StatRoyale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class API {
    public Player player;
    public Card card;
    Chest chest;
    String apiKey = Config.getKey("CLASH_ROYALE_API_KEY");
    String base_url = Config.getURL("BASE_URL");
    String tag = "#U9JP0JVR";

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

    public void requestPlayerStats() {
        try {
            player = objectMapper.readValue(restClient.get().uri("/players/{playerTag}", tag).retrieve().body(String.class), Player.class);
            player.displayPlayerStats();
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
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

    public void requestChests() {
        try {
            chests = objectMapper.readValue(restClient.get().uri("/players/{playerTag}/upcomingchests", tag).retrieve().body(String.class), ChestList.class);
            chests.getUpcomingChests();
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
        }
    }


}
