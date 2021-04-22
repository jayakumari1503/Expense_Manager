package Task_4_3.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AllTransaction {
    HashMap<String, ArrayList<Transaction>> dailyTransaction = new HashMap<>();
    ArrayList<Transaction> transactions;
    float total = 0;
    Scanner scanner = new Scanner(System.in);


    //Add transaction
    public void add(Transaction transaction) {
        LocalDate localDate = LocalDate.parse(transaction.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();

        if (dailyTransaction.containsKey(key)) {
            dailyTransaction.get(key).add(transaction);
            for (int i = 0; i < dailyTransaction.get(key).size(); i++) {
                total  = total + dailyTransaction.get(key).get(i).expense + dailyTransaction.get(key).get(i).income;
            }
        }
        else{
            transactions =new ArrayList<>();
            transactions.add(transaction);
            dailyTransaction.put(key,transactions);
            total = transaction.expense + transaction.income;
        }
        System.out.print(total);
    }


    public void edit(Transaction transaction) {
        LocalDate localDate = LocalDate.parse(transaction.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();

        if (dailyTransaction.get(key).contains(transaction)) {
            System.out.print("Enter new expense :");
            float expense = scanner.nextFloat();
            System.out.print("Enter new income :");
            float income = scanner.nextFloat();
            System.out.print("Enter new date(dd MMM yyyy) :");
            String date = scanner.nextLine();

            Transaction transaction1 = new Transaction(date, expense,income);
            int trans = dailyTransaction.get(key).indexOf(transaction);
            dailyTransaction.get(key).set(trans, transaction1);
        } else
            System.out.print("Required transaction not available.");
    }


    public void delete(Transaction transaction) {
        LocalDate localDate = LocalDate.parse(transaction.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
        if (dailyTransaction.containsKey(key)) {
            if (dailyTransaction.get(key).contains(transaction)) {
                dailyTransaction.get(key).remove(transaction);
            } else
                System.out.print("Required transaction not available.");
        }
        System.out.print("Required transaction not available.");
    }

    public void showTransactionByMonth (String month, int year) {
        String key = month + " " + year;
        System.out.print("Required month summary :");

        if(dailyTransaction.containsKey(key)) {
            float totalExpense;
            float totalIncome;

            for (int i = 0; i < dailyTransaction.get(key).size(); i++) {
                totalExpense = dailyTransaction.get(key).get(i).expense;
                totalIncome = dailyTransaction.get(key).get(i).income;
                total = dailyTransaction.get(key).get(i).expense + dailyTransaction.get(key).get(i).expense;
                System.out.print("Expense : " + totalExpense + "\nIncome :" + totalIncome +
                        "Date:" + dailyTransaction.get(key).get(i).date);
            }
        }
                else
                System.out.print("No transaction occur in this month.");
    }
}

