public class Operacao {
    private String moedaOrigem;
    private String moedaDestino;
    private double quantidade;
    private double resultado;

    public Operacao(String moedaOrigem, String moedaDestino, double quantidade, double resultado) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.quantidade = quantidade;
        this.resultado = resultado;
    }

    // Getters e setters se necessário
}
