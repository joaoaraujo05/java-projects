package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product p = new Product();

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        Product product = new Product(name, price);

        product.setName("Computer"); // recebe o novo valor
        System.out.println("Updated name: " + product.getName()); //imprime o novo valor
        product.setPrice(1200.00);
        System.out.println("Updated price: " + product.getPrice());

        System.out.println();
        System.out.println("Product data: " + product);

        System.out.println();
        System.out.println("Enter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity); // faz a atualizacao da quantidade dentro do objeto product

        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.println("Enter the number of products to be removed in stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity); // atualizando a classe removendo a quantity

        System.out.println();
        System.out.println("Updated data: " + product);

        sc.close();
    }
}
