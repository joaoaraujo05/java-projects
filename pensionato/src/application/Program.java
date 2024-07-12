package application;

import entities.Rent;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rooms will be rented? ");
        int n = sc.nextInt();

        Rent[] vect = new Rent[10]; // criar 0 a 9, nulas

        for (int i=1; i<=n; i++) { //nao tem nada a ver com o vetor,so vai repetir as frases
            System.out.printf("Rent #%d\n", i);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Room: ");
            int room = sc.nextInt();
            vect[room] = new Rent(name, email); // instanciando o objteo e atribuindo a referencia dele para o vetor na posicao do room
        }

        System.out.println("Busy rooms: ");
        for (int i=0; i < 10; i++) {
            if (vect[i] != null) {
                System.out.println(i + ": " + vect[i]);
            }
        }

        sc.close();
    }
}
