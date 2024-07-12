package entities;

public class Account {
    private int numberAccount;
    private String holderAccount;
    private double balance;

    public Account(int numberAccount, String holderAccount, double initialValue) {
        this.numberAccount = numberAccount;
        this.holderAccount = holderAccount;
        deposit(initialValue);
    }

    public Account(int numberAccount, String holderAccount) {
        this.numberAccount = numberAccount;
        this.holderAccount = holderAccount;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public String getHolderAccount() {
        return holderAccount;
    }

    public void setHolderAccount(String holderAccount) {
        this.holderAccount = holderAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount + 5.00;
    }

    public String toString() {
        return "Account "
                + numberAccount
                + ", Holder: "
                + holderAccount
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}
