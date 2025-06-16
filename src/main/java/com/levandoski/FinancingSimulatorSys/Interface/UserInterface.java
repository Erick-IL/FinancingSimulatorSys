package com.levandoski.FinancingSimulatorSys.Interface;

import com.levandoski.FinancingSimulatorSys.Financing.Financing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    /*
    Classe Responsável por lidar com a entrada de dados do usuário. Estes dados podem ser recebidos via entrada do usuário usando o Scanner.
    */

    static Scanner scanner = new Scanner(System.in);

    // ------ * Métodos * ------ //

    static public void financePanel() {
        while (true) {
            try {
                System.out.println("\n" + "-".repeat(50) + " Simulador de Financiamento " + "-".repeat(50));
                System.out.println("1 - Simular Financiamento.");
                System.out.println("2 - Listar Financiamentos.");
                System.out.println("3 - Sair.");
                System.out.print("Selecione uma opção: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:

                        createFinancing();
                        break;
                    case 2:
                        Financing.listFinancings();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor selecione uma opção valida.");
                scanner.nextLine();
            }
        }
    }

    public static void createFinancing() {
        System.out.println("\n" + "-".repeat(50) + " Crie um financiamento " + "-".repeat(50));
        double propertyValue = askPropertyValue();
        double annualInterestRate = askAnnualInterestRate();
        int termFinance = askTermFinancing();
        Financing financing = new Financing(propertyValue, annualInterestRate, termFinance);
        financing.listFinancing();
    }

    public static Double askPropertyValue() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                String Entry = scanner.nextLine().replace(',', '.'); // pega o valor e troca a ',' para '.'
                if (Entry.equals("0")) {
                    System.out.println("O Valor do imóvel deve ser maior que zero.");
                    continue;
                }
                return Double.parseDouble(Entry); // transforma em double
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Insira um valor Valido.");
            }
        }
    }


    public static Double askAnnualInterestRate() {
        while (true) {
            try {
                System.out.print("Digite a Taxa de juros anual: ");
                String Entry = scanner.nextLine().replace(',', '.'); // pega o valor e troca a ',' para '.'
                if (Entry.equals("0")) {
                    System.out.println("A taxa deve ser maior que zero.");
                    continue;
                }
                return Double.parseDouble(Entry); // transforma em double
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Insira um valor Valido.");
                scanner.nextLine();
            }
        }
    }

    public static int askTermFinancing() {
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento (Em anos): ");
                int Entry = scanner.nextInt();
                if (Entry <= 0) {
                    System.out.println("O prazo do financiamento deve ser maior que zero.");
                    continue;
                }
                return Entry;
            } catch (InputMismatchException e) {
                System.out.println("Insira um valor Valido.");
                scanner.nextLine();
            }
        }
    }
}
