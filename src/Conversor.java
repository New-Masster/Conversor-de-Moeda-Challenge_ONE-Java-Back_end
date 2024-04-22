import java.util.Scanner;

public class Conversor {
    private Scanner scanner;
    private Historico historico;

    public Conversor() {
        this.scanner = new Scanner(System.in);
        this.historico = new Historico();
    }

    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o nextInt()

            switch (opcao) {
                case 1:
                    converterMoeda("USD", "ARS", "Dólar", "Peso Argentino", "$", "$");
                    break;
                case 2:
                    converterMoeda("ARS", "USD", "Peso Argentino", "Dólar", "$", "$");
                    break;
                case 3:
                    converterMoeda("USD", "BRL", "Dólar", "Real Brasileiro", "$", "R$");
                    break;
                case 4:
                    converterMoeda("BRL", "USD", "Real Brasileiro", "Dólar", "R$", "$");
                    break;
                case 5:
                    converterMoeda("USD", "COP", "Dólar", "Peso Colombiano", "$", "COL$");
                    break;
                case 6:
                    converterMoeda("COP", "USD", "Peso Colombiano", "Dólar", "COL$", "$");
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    private void converterMoeda(String moedaOrigem, String moedaDestino, String nomeOrigem, String nomeDestino, String simboloOrigem, String simboloDestino) {
        System.out.println("Digite a quantidade de " + nomeOrigem + ":");
        double quantidade = scanner.nextDouble();
        double resultado = TaxaCambio.obterValorMoeda(moedaOrigem, moedaDestino) * quantidade;
        System.out.println(simboloOrigem + " " + quantidade + " equivalem a " + simboloDestino + " " + resultado + ".");
        historico.adicionarOperacao(new Operacao(moedaOrigem, moedaDestino, quantidade, resultado));
    }

    private void exibirMenu() {
        System.out.println("***************************************************************");
        System.out.println("Seja bem-vindo ao Conversor de Moeda");
        System.out.println("1 ) Dólar =>> Peso Argentino");
        System.out.println("2 ) Peso Argentino =>> Dólar");
        System.out.println("3 ) Dólar =>> Real Brasileiro");
        System.out.println("4 ) Real Brasileiro =>> Dólar");
        System.out.println("5 ) Dólar =>> Peso Colombiano");
        System.out.println("6 ) Peso Colombiano =>> Dólar");
        System.out.println("7 ) Sair");
        System.out.println("Escolha uma opção válida:");
        System.out.println("***************************************************************");
    }
}
