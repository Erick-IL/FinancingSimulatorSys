import java.util.InputMismatchException;
import java.util.Scanner;

class Financing {
    /*
    Classe responsável por Lidar com os cálculos do financiamento
     */

    // inicia as variáveis
    Double propertyValue; // Valor do imóvel
    Double annualInterestRate; // Taxa anual
    int termFinancing; // Prazo de financiamento

    // Em outras palavras um "__init__" do python, mas é preciso criar as variáveis antes
    Financing(Double propertyValue, Double annualInterestRate, int termFinancing) {
        this.propertyValue = propertyValue;
        this.annualInterestRate = annualInterestRate;
        this.termFinancing = termFinancing;
    }

    // ------ * Métodos * ------ //

    // Pagamento mensal = (valor do imóvel / (prazo do financiamento em anos * 12)) * (1 + (taxa anual / 12))
    Double calculateMonthlyPayment() {
        return (propertyValue / (termFinancing * 12) * (1 + annualInterestRate / 12));
    }

    // Total do pagamento = pagamento mensal * prazo do financiamento em anos * 12
    Double calculatePayment( ) {
        return (calculateMonthlyPayment() * termFinancing * 12 );
    }
}

class UserInterface {
    /*
    Classe Responsável por lidar com a entrada de dados do usuário. Estes dados podem ser recebidos via entrada do usuário usando o Scanner.
    */

    Scanner scanner = new Scanner(System.in);

    // ------ * Métodos * ------ //

    Double askPropertyValue() {
        System.out.print("Digite o valor do imóvel: ");
        String Entry = scanner.nextLine().replace(',' ,'.'); // pega o valor e troca a ',' para '.'
        return Double.parseDouble(Entry); // transforma em double
    }

    Double askAnnualInterestRate() {
        System.out.print("Digite a Taxa de juros anual: ");
        String Entry = scanner.nextLine().replace(',' ,'.'); // pega o valor e troca a ',' para '.'
        return Double.parseDouble(Entry); // transforma em double
    }

    int askTermFinancing() {
        System.out.print("Digite o prazo do financiamento (Em anos): ");
        return scanner.nextInt(); // pega o valor
    }
}


public class Main {
    static UserInterface userInterface = new UserInterface();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

            while (true) {
                try {
                    Double annualInterestRate = userInterface.askAnnualInterestRate();
                    Double propertyValue = userInterface.askPropertyValue();
                    int termFinancing = userInterface.askTermFinancing();

                    Financing financing = new Financing(propertyValue, annualInterestRate, termFinancing);

                    System.out.println("\n--- Simulação Concluída ---");
                    System.out.printf("Pagamento mensal: R$ %.2f%n", financing.calculateMonthlyPayment());
                    System.out.printf("Pagamento total: R$ %.2f%n", financing.calculatePayment());


                    System.out.println("Deseja fazer mais uma simulação? (s/n)");

                    if (!scanner.nextLine().equals("s")) {
                        break;
                    }


                } catch (InputMismatchException _) {
                    System.out.println("Tipo de dado invalido, Tente novamente.");

                }

            }
    }
}