package Task_4_3.models;

import java.util.HashMap;
import java.util.Scanner;

public class TransactionOperation {
    private final static Scanner scanner = new Scanner(System.in);
    HashMap<String, Transaction> transaction = new HashMap<>();


    public static void addExpenseTransaction(HashMap<String, Transaction> transactions) {
        System.out.println(" Enter Date (dd MMM yyyy ) :");
        String date = scanner.nextLine();
        System.out.println("Enter amount :");
        float expense = scanner.nextFloat();

        Transaction transaction = new Transaction(date, expense);
        AllTransaction allTransaction = new AllTransaction();
        allTransaction.add(transaction);
        System.out.println("Done! Transaction added successfully.");
    }

    public static void addIncomeTransaction(HashMap<String, Transaction> transactions) {
        System.out.println(" Enter Date (dd MMM yyyy ) :");
        String date = scanner.nextLine();
        System.out.println("Enter income :");
        float income = scanner.nextFloat();

        Transaction transaction = new Transaction(date, income);
        AllTransaction allTransaction = new AllTransaction();
        allTransaction.add(transaction);

        System.out.println("Done! Transaction added successfully.");
    }
    

    public static void editIncomeTransaction(HashMap<String, Transaction> transactions) {
        System.out.println("Enter new date (dd MMM yyyy):");
        String date = scanner.nextLine();
        System.out.println("Enter new income :");
        float income = scanner.nextFloat();

        Transaction transaction = new Transaction(date,income);
        AllTransaction allTransaction = new AllTransaction();
        allTransaction.edit(transaction);

        System.out.println("Done! Transaction edited successfully.");
    }

    public static void editExpenseTransaction(HashMap<String, Transaction> transactions) {
        System.out.println("Enter new date (dd MMM yyyy):");
        String date = scanner.nextLine();
        System.out.println("Enter new expense :");
        float expense = scanner.nextFloat();

        Transaction transaction = new Transaction(date, expense);
        AllTransaction allTransaction = new AllTransaction();
        allTransaction.edit(transaction);
        System.out.println("Done! Transaction edited successfully.");

    }

    public static void deleteIncomeTransaction(HashMap<String, Transaction> transactions) {
        System.out.println("Enter date(dd MMM yyyy) :");
        String date = scanner.nextLine();
        AllTransaction allTransaction = new AllTransaction();
        allTransaction.delete(transactions.get(date));

        System.out.println("Transaction deleted successfully.");
    }

    public static void deleteExpenseTransaction(HashMap<String, Transaction> transactions) {
        System.out.println("Enter date(dd MMM yyyy) :");
        String date = scanner.nextLine();
        AllTransaction allTransaction = new AllTransaction();
        allTransaction.delete(transactions.get(date));
        System.out.println("Transaction deleted successfully.");

    }

    public static void showTransaction() {
        System.out.print("Enter month :");
        String month = scanner.nextLine();

        System.out.print("Enter year :");
        int year = scanner.nextInt();

        AllTransaction allTransaction = new AllTransaction();
        allTransaction.showTransactionByMonth(month, year);
    }
}
