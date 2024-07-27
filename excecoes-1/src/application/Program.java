package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            String date1 = sc.next();
            LocalDate checkIn = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            String date2 = sc.next();
            LocalDate checkOut = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            date1 = sc.next();
            checkIn = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            date2 = sc.next();
            checkOut = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation " + reservation);
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
