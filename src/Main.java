import model.Company;
import model.Individual;
import model.TaxPayer;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");

        int taxPayer = sc.nextInt();
        sc.nextLine();
        ArrayList<TaxPayer> taxPayers = new ArrayList<>();

        for(int i = 1; i <= taxPayer; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            String typeOfPayer = sc.next();
            while(!typeOfPayer.equals("i") && !typeOfPayer.equals("c")){
                System.out.print("Wrong insert, try to insert (i/c): ");
                typeOfPayer = sc.next();
            }
            if(typeOfPayer.equals("i")){
                System.out.print("Name: ");
                String name = sc.next();
                sc.nextLine();
                System.out.print("Anual income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Health Expenditures: ");
                double healthExpeditures = sc.nextDouble();
                taxPayers.add(new Individual(name, anualIncome, healthExpeditures));

            } else
              if(typeOfPayer.equals("c")){
                  System.out.print("Name: ");
                  String name = sc.next();
                  sc.nextLine();
                  System.out.print("Anual income: ");
                  double anualIncome = sc.nextDouble();
                  System.out.print("Number of employees: ");
                  int employees = sc.nextInt();
                  taxPayers.add(new Company(name, anualIncome, employees));
              }
        }

        double totalTaxes = 0;

        System.out.println("TAXES PAID:");
        for(TaxPayer taxP : taxPayers){
            System.out.println(String.format(taxP.getName() + ": " + "%.2f", taxP.getTotalTaxes()));
            totalTaxes += taxP.getTotalTaxes();
        }
        System.out.printf(String.format("TOTAL TAXES: $ %.2f", totalTaxes));
    }
}


//
//        Company taxPayer = new Company("Padaria Tradicao", 50000.00, 25);
//
//        System.out.println(taxPayer.getTotalTaxes());
//
//        Individual individual = new Individual("Deivid", 26000.00, 3000);
//
//        System.out.println(individual.getTotalTaxes());