package com.aluracursos.conversormodenas.main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public String consultaConversion(String monedaEntrada){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6dada57cb8f5fb320286bcbf/latest/" + monedaEntrada);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //return new Gson().fromJson(response.body(), MonedaConversion.class);
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
