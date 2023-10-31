package co.wedevx.digitalbank.automation.ui.models;

public class DepositInfo {

    private String accountName;
    private double balance;
    private String depositAmount;
    private String newBalance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double  balance) {
        this.balance = balance;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(String newBalance) {
        this.newBalance = newBalance;
    }

    public DepositInfo(String accountName, double balance, String depositAmount, String newBalance) {
        this.accountName = accountName;
        this.balance = balance;
        this.depositAmount = depositAmount;
        this.newBalance = newBalance;


    }
}
