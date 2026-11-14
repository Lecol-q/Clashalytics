package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.config.Config;
import Collin_Le.StatRoyale.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class API {
    public Player player;
    public Card card;
    public List<Card> cards;
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

    public BattleLog requestBattleLog(String tag) {
        try {
            List<Battle> battle = objectMapper.readValue(restClient.get().uri("/players/{playerTag}/battlelog", tag).retrieve().body(String.class), new TypeReference<List<Battle>>() {});
            BattleLog battleLog = new BattleLog(battle);
            battleLog.displayBattleLog();
            return battleLog;

        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
            return null;
        }
    }

    public Leaderboard requestTopThreeGlobalPlayers() {
        try {
            Leaderboard leaderboard  = objectMapper.readValue(restClient.get().uri("/locations/global/pathoflegend/players?limit=3").retrieve().body(String.class), Leaderboard.class);
            leaderboard.displayGlobalPlayers();
            return leaderboard;
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
            return null;
        }
    }


    // dead code, dead code
    public void requestChests(String tag) {
        try {
            chests = objectMapper.readValue(restClient.get().uri("/players/{playerTag}/upcomingchests", tag).retrieve().body(String.class), ChestList.class);
            chests.getUpcomingChests();
        } catch(HttpClientErrorException.NotFound k) {
            System.out.println(k);
        }
    }
}
