package src.com.aluracursos.challenge.hooks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import src.com.aluracursos.challenge.records.Change;

public class BuscarCambio {

    public static Change cambio(String cambioA, String cambioB) {
        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/b7dc731c957748ad2b5b8f9a/pair/"+cambioA+"/"+cambioB);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(req, HttpResponse.BodyHandlers.ofString());
            String json = String.valueOf(response.body());

            return new Gson().fromJson(json, Change.class);
        } catch (Exception e) {
            throw new RuntimeException("Hubo un problema al intentar buscar el tipo de cambio.");
        }
    }

}
