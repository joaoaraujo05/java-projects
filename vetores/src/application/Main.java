package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Fazer um programa para ler um numero inteiro N e os dados
        (nome e preço) de N Produtos. Armazene os N produtos em um vetor.
        Em seguida, mostrar o preço médio dos produtos.*/

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] vect = new Product[n];

        for (int i=0; i<n; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            double price = sc.nextDouble();
            vect[i] = new Product(name, price);
        }

        double sum = 0.0;
        for (int i=0; i<n; i++) {
            sum += vect[i].getPrice();
        }

        System.out.printf("AVERAGE PRICE = %.2f\n", sum / n);


        sc.close();

    }
}