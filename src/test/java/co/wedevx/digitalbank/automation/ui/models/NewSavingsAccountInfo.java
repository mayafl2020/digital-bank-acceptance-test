package co.wedevx.digitalbank.automation.ui.models;

public class NewSavingsAccountInfo {



    private String  selectSavingsAccountType;
    private String  selectAccountOwnership;
    private String accountName;
    private double initialDeposit;

    public NewSavingsAccountInfo(String selectSavingsAccountType, String selectAccountOwnership, String accountName, double initialDeposit) {
        this.selectSavingsAccountType = selectSavingsAccountType;
        this.selectAccountOwnership = selectAccountOwnership;
        this.accountName = accountName;
        this.initialDeposit = initialDeposit;
    }

    public String getSelectSavingsAccountType() {
        return selectSavingsAccountType;
    }

    public void setSelectSavingsAccountType(String selectSavingsAccountType) {
        this.selectSavingsAccountType = selectSavingsAccountType;
    }

    public String getSelectAccountOwnership() {
        return selectAccountOwnership;
    }

    public void setSelectAccountOwnership(String selectAccountOwnership) {
        this.selectAccountOwnership = selectAccountOwnership;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}

