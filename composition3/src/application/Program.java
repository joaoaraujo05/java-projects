package application;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        LocalDateTime localDateTime = LocalDateTime.now();


        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date1 = sc.next();
        LocalDate birthDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        sc.nextLine();
        String status = sc.nextLine();
        Order order = new Order(OrderStatus.valueOf(status), client); // tem que passar os dados do cliente para a classe order

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.printf("Enter #%d item data: \n", i);
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem items = new OrderItem(quantity, productPrice, new Product(productName));
            order.addItems(items);
        }

        System.out.println("ORDER SUMMARY");
        System.out.println("Order moment: " + localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + order.getClient().getName() + "(" + order.getClient().getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ") - " + order.getClient().getEmail());
        System.out.println("Order items: ");
        System.out.println(order);

        sc.close();
    }
}
