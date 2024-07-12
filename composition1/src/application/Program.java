package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.printf("Enter contract #%d data: \n", i);
            System.out.print("Date (DD/MM/YYYY): ");
            String date1 = sc.next();
            LocalDate contractDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));//O método LocalDate.parse é usado para converter uma string que representa uma data em um objeto LocalDate.
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract); //adicionando o contrato na lista da classe worker
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");

        //pegando ano e dia e transformando em inteiros para usar na funcao
        String mouthAndYear = sc.next();
        int month = Integer.parseInt(mouthAndYear.substring(0, 2));
        int year = Integer.parseInt(mouthAndYear.substring(3)); // 3 em diante

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + mouthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
