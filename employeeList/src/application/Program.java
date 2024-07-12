package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.println();
            System.out.printf("Employee #%d\n", i+1);
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary); // instanciando o funcionario (dados)

            list.add(emp); // adicionando ele na lista
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id doesn't exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees: ");
        for (Employee x : list) { // para cada Employee x na lista
            System.out.println(x);
        }

        sc.close();
    }
}
