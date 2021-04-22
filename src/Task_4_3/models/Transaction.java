package Task_4_3.models;

public class Transaction {
    public String date;
    public float income;
    public float expense;

    public Transaction(String date, float expense, float income) {
        this.date = date;
        this.income = income;
        this.expense = expense;
    }

    public Transaction(String date, float income) {
        this.date = date;
        this.income = income;
    }


    @Override
        public String toString() {
        return "Income :" + income + "\nExpense :" + expense + " \t\t\t\t " + date;
    }
}
