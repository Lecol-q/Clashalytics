package Collin_Le.StatRoyale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.io.*;
import java.net.*;

@Component
public class API {
    Player player;
    String apiKey = Config.getKey("CLASH_ROYALE_API_KEY");
    String base_url = Config.getURL("BASE_URL");
    String tag = "%23U9JP0JVR";

    // ObjectMapper section
    private static ObjectMapper objectMapper = new ObjectMapper();

    RestClient restClient = RestClient.builder()
            .baseUrl(base_url)
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .build();

    public void request() throws IOException {
        player = objectMapper.readValue(restClient.get().uri("/players/" + tag).retrieve().body(String.class), Player.class);
    }




}
