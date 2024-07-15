import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaConversion {
    public ValoresConvertidos convertirValores(String monedaOriginal, String monedaAConvertir, Double valorAConvertir) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/12272c11061f8dd85cbea08d/pair/" + monedaOriginal + "/" + monedaAConvertir + "/" + valorAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ValoresConvertidos.class);
        } catch (Exception e) {
            throw new RuntimeException("No pude realizar la conversion.");
        }
    }
}
