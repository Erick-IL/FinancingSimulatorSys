package com.levandoski.FinancingSimulatorSys.Financing;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Financing {
    /*
    Classe responsável por Lidar com os cálculos do financiamento
     */

    // inicia as variáveis
    private final double propertyValue; // Valor do imóvel
    double annualInterestRate; // Taxa anual
    int termFinancing; // Prazo de financiamento

    double TotalFinancingPayment;
    double FinancingMonthlyPayment;

    static NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
    static ArrayList<Financing> financingList = new ArrayList<>();

    // Em outras palavras um "__init__" do python, mas é preciso criar as variáveis antes
    public Financing(double propertyValue, double annualInterestRate, int termFinancing) {
        this.propertyValue = propertyValue;
        this.annualInterestRate = annualInterestRate;
        this.termFinancing = termFinancing;
        this.FinancingMonthlyPayment = calculateMonthlyPayment();
        this.TotalFinancingPayment = calculatePayment();
        financingList.add(this);
    }

    // ------ * Métodos * ------ //

    // Pagamento mensal = (valor do imóvel / (prazo do financiamento em anos * 12)) * (1 + (taxa anual / 12))
    public double calculateMonthlyPayment() {
        return (propertyValue / (termFinancing * 12)) * (1 + (annualInterestRate / 12));
    }

    // Total do pagamento = pagamento mensal * prazo do financiamento em anos * 12
    public double calculatePayment() {
         return (FinancingMonthlyPayment * termFinancing * 12);
    }


    public static void listFinancings() {
        System.out.println("\n" + "-".repeat(50) + "Total de " + financingList.size() + " Financiamento(s)" + "-".repeat(50));
        for (int i =0;  i < financingList.size(); i++) {
            Financing f = financingList.get(i);
            System.out.println("\n" + "Financiamento #" + (i + 1));
            System.out.println("Detalhes do Financiamento: " + f.getAnnualInterestRate() + " % de taxa a.a" + "  -  " + f.getTermFinancing() + " anos.");
            System.out.println("Valor do imóvel de R$ " + nf.format(f.getTotalFinancingPayment()));
            System.out.println("Mensalidade de R$ " + String.format("%.2f", f.getFinancingMonthlyPayment()));
            System.out.println("Total de R$ " + String.format("%.2f", f.getTotalFinancingPayment()));

        }
    }

    public void listFinancing() {
        System.out.println("\n" + "-".repeat(50) + " Financiamento Criado " + "-".repeat(50));
        System.out.println("Detalhes do Financiamento: " + getAnnualInterestRate() + " %" + "  -  " + getTermFinancing() + " anos.");
        System.out.println("Valor do imóvel de R$ " + nf.format(getPropertyValue()));
        System.out.println("Mensalidade de R$ " + String.format("%.2f", getFinancingMonthlyPayment()));
        System.out.println("Total de R$ " + String.format("%.2f", getTotalFinancingPayment()));
    }

    // ------ * Getters * ----- //

    public double getPropertyValue() {
        return propertyValue;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getTermFinancing() {
        return termFinancing;
    }

    public double getTotalFinancingPayment() {
        return TotalFinancingPayment;
    }

    public double getFinancingMonthlyPayment() {
        return FinancingMonthlyPayment;
    }


}
