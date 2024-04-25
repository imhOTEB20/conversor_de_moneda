package com.aluralatam.convertidor_monedas.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
    private final String key;
    private String url;
    private final HttpClient client;
    private final String DIRECCION = "https://v6.exchangerate-api.com/v6/";

    public Conexion(String key) {
        this.key = key;
        this.client = HttpClient.newHttpClient();
    }

    private void generateURL(String base_code) {
        this.url = this.DIRECCION + this.key + "/latest/" + base_code;
        System.out.println(this.url);
    }

    public String getResponse(String base_code) throws IOException, InterruptedException {
        this.generateURL(base_code);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
