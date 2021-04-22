package Task_4_3;

import Task_4_3.models.*;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Transaction> transactions = new HashMap<>();

        System.out.println("welcome to EXPENSE MANAGER");
        System.out.println("You can do following operations-");
        String message = """
                1.Add Transaction
                2.Edit Transaction
                3.Delete Transaction
                4.Show transaction by Month
                5.Exit""";

        String message1 = """
                Select Type :\s
                1.expense
                2.Income
                3.Go Back""";

        System.out.println(message);
        System.out.print("Enter operation :");
        int operation = scanner.nextInt();
        switch (operation) {
            case 1 :
            System.out.print(message1);
            System.out.print("\nEnter type :");
            int type = scanner.nextInt();
                switch (type) {
                    case 1 -> TransactionOperation.addExpenseTransaction(transactions);
                    case 2 -> TransactionOperation.addIncomeTransaction(transactions);
                    case 3 -> System.out.print(message);
                    default ->System.out.print("Error! Invalid Type.");
                }
                System.out.println(message1);
                break;

            case 2 :
                    System.out.print(message1);
                    type = scanner.nextInt();
                switch (type) {
                    case 1 -> TransactionOperation.editExpenseTransaction(transactions);
                    case 2 -> TransactionOperation.editIncomeTransaction(transactions);
                    case 3 -> System.out.print(message);
                    default -> System.out.print("Error! Invalid Type.");
                }
                System.out.println(message1);
                break;

            case 3:
                System.out.print(message1);
                type = scanner.nextInt();
                switch (type) {
                    case 1 -> TransactionOperation.deleteExpenseTransaction(transactions);
                    case 2 -> TransactionOperation.deleteIncomeTransaction(transactions);
                    case 3 -> System.out.print(message);
                    default ->System.out.print("Error! Invalid Type.");
                }
                System.out.println(message1);



            case 4: TransactionOperation.showTransaction();
                break;

            case 5 : System.out.print("You exit the application.");
            break;

            default : System.out.println("Error! Invalid Operation.");

        }
    }
}