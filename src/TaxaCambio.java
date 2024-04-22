import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TaxaCambio {
    public static double obterValorMoeda(String moedaOrigem, String moedaDestino) {
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + moedaOrigem);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();

            JsonObject json = JsonParser.parseString(resposta.toString()).getAsJsonObject();
            return json.getAsJsonObject("rates").get(moedaDestino).getAsDouble();
        } catch (IOException e) {
            System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            return 0.0;
        }
    }
}
