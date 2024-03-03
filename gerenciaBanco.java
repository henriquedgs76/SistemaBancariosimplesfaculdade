import java.util.Scanner;

public class gerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.println("Bem-vindo ao Sistema Bancário do Henrique!");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    informarDadosPessoais(scanner, conta);
                    break;
                case 2:
                    consultarSaldo(conta);
                    break;
                case 3:
                    realizarOperacao(scanner, conta, "depósito");
                    break;
                case 4:
                    realizarOperacao(scanner, conta, "saque");
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar o Sistema Bancário do Henrique!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Informe seus dados pessoais");
        System.out.println("2 - Consultar seu saldo");
        System.out.println("3 - Fazer depósito");
        System.out.println("4 - Fazer saque");
        System.out.println("5 - Encerrar");
    }

    public static void informarDadosPessoais(Scanner scanner, ContaBancaria conta) {
        System.out.println("Por favor, informe seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Agora, informe seu sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.println("E por último, seu CPF:");
        String cpf = scanner.nextLine();
        conta.setDadosPessoais(nome, sobrenome, cpf);
        System.out.println("Dados pessoais atualizados com sucesso!");
    }

    public static void consultarSaldo(ContaBancaria conta) {
        System.out.println("Seu saldo atual é de R$" + conta.consultarSaldo());
    }

    public static void realizarOperacao(Scanner scanner, ContaBancaria conta, String operacao) {
        System.out.println("Informe o valor do " + operacao + ":");
        double valorOperacao = scanner.nextDouble();
        if (operacao.equals("depósito")) {
            conta.depositar(valorOperacao);
        } else if (operacao.equals("saque")) {
            conta.sacar(valorOperacao);
        }
    }
}

class ContaBancaria {
    @SuppressWarnings("unused")
    private String nome;
    @SuppressWarnings("unused")
    private String sobrenome;
    @SuppressWarnings("unused")
    private String cpf;
    private double saldo;

    public void setDadosPessoais(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }
}
