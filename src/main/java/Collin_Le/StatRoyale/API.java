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
    Player player;
    Card card;
    String apiKey = Config.getKey("CLASH_ROYALE_API_KEY2");
    String base_url = Config.getURL("BASE_URL");
    String tag = "#U9JP0JVR";

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
            List<Card> items = objectMapper.readValue(restClient.get().uri("/cards?limit=1").retrieve().body(String.class), new TypeReference<List<Card>>() {
            });
            items.displayCardStats();
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
        }
    }




}
