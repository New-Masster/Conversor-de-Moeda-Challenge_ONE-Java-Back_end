import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
    public static String lerArquivo(String nomeArquivo) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
        return conteudo.toString();
    }

    public static void escreverArquivo(String nomeArquivo, String conteudo) throws IOException {
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(conteudo);
        }
    }
}
