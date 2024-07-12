package application;

import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        double price = sc.nextDouble();

        System.out.println("How many dollars will be bought? ");
        double buyingDollars = sc.nextDouble();

        double v = CurrencyConverter.payment(price, buyingDollars);

        System.out.printf("Amount to be paid in reais = %.2f", CurrencyConverter.payment(price, buyingDollars));

        sc.close();

    }
}
