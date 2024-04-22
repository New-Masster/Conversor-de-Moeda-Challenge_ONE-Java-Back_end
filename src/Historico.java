import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<Operacao> operacoes;
    private static final String HISTORICO_FILE = "historico.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Historico() {
        this.operacoes = new ArrayList<>();
        carregarHistorico();
    }

    private void carregarHistorico() {
        try {
            Type listType = new TypeToken<ArrayList<Operacao>>(){}.getType();
            List<Operacao> historicoCarregado = gson.fromJson(lerArquivo(HISTORICO_FILE), listType);
            if (historicoCarregado != null) {
                this.operacoes = historicoCarregado;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar histórico: " + e.getMessage());
        }
    }

    public void adicionarOperacao(Operacao operacao) {
        operacoes.add(operacao);
        salvarHistorico();
    }

    private void salvarHistorico() {
        try {
            escreverArquivo(HISTORICO_FILE, gson.toJson(operacoes));
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico: " + e.getMessage());
        }
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    private String lerArquivo(String nomeArquivo) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
        return conteudo.toString();
    }

    private void escreverArquivo(String nomeArquivo, String conteudo) throws IOException {
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(conteudo);
        }
    }
}
