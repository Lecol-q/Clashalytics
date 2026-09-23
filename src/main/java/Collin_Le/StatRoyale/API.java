package Collin_Le.StatRoyale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.io.*;
import java.net.*;

@Component
public class API {
    String apiKey = Config.getKey("CLASH_ROYALE_API_KEY");

    public void requestPlayerName() throws IOException {
        URL url = new URL(Config.getURL("BASE_URL"));
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Authorization", "Key" + apiKey);
        BufferedReader inRead = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));


    }



}
