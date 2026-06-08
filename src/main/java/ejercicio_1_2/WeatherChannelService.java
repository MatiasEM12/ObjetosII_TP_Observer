package ejercicio_1_2;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherChannelService implements ClimaOnline {

    private String urlService;

    public WeatherChannelService(String url){
        this.urlService=url;
    }
    @Override
    public String temperatura() {
        try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlService)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            double temperatura = json.getJSONObject("main").getDouble("temp");

            return temperatura + " c";

        }catch(IOException | InterruptedException e){
            throw new RuntimeException(e);
        }



    }
}