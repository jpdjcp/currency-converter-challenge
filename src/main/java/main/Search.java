package main;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Search {

    public Conversion search(String currency1, String currency2) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://v6.exchangerate-api.com/v6/2f74f3e38c9a2f0bf46567bb/pair/"
                + currency1
                +
                "/"
                + currency2);
        HttpClient client = HttpClient
                .newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Conversion.class);
    }
}
