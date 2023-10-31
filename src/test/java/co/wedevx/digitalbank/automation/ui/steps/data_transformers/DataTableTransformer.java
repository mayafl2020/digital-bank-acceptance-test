package co.wedevx.digitalbank.automation.ui.steps.data_transformers;

import co.wedevx.digitalbank.automation.ui.models.*;
import io.cucumber.java.DataTableType;


import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public AccountCard accountCardEntry(Map<String, String> entry) {
        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        long accountNumber = Long.parseLong(entry.get("accountNumber"));
        String interestRate = entry.get("interestRate");
        double balance = Double.parseDouble(entry.get("balance"));

        return new AccountCard(accountName, accountType, ownership, accountNumber, interestRate, balance);
    }

    @DataTableType
    public Transactions transactionsEntry(Map<String, String> entry) {
        String date = entry.get("date");
        String category = entry.get("category");
        String description = entry.get("description");
        double amount = Double.parseDouble(entry.get("amount"));
        double balance = Double.parseDouble(entry.get("balance"));

        return new Transactions(date, category, description, amount, balance);
    }

    @DataTableType
    public NewCheckingAccountInfo newCheckingAccountEntry(Map<String, String> entry) {

        String checkingAccountType = entry.get("checkingAccountType");
        String accountOwnership = entry.get("accountOwnership");
        String accountName = entry.get("accountName");
        double initialDepositAccount = Double.parseDouble(entry.get("initialDepositAccount"));

        return new NewCheckingAccountInfo(checkingAccountType, accountOwnership, accountName, initialDepositAccount);
    }

    @DataTableType
    public NewSavingsAccountInfo newSavingsAccountEntry(Map<String, String> entry) {

        String selectSavingsAccountType = entry.get("selectSavingsAccountType");
        String selectAccountOwnership = entry.get(" selectAccountOwnership");
        String accountName = entry.get("accountName");
        double initialDeposit = Double.parseDouble(entry.get("initialDeposit"));

        return new NewSavingsAccountInfo(selectSavingsAccountType, selectAccountOwnership, accountName, initialDeposit);
    }

    @DataTableType
    public RegistrationInfo newAccountEntry(Map<String,String>entry){

        String title = entry.get("titile");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String gender = entry.get("gender");
        int dateOfBirth = Integer.parseInt(entry.get("dateOfBirth"));
        int ssn = Integer.parseInt(entry.get("ssn"));
        String email = entry.get("email");
        String password = entry.get("password");
        String confirmPassword = entry.get("confirmPassword");

        return new RegistrationInfo(title,firstName,lastName,gender,dateOfBirth,ssn,email,password,confirmPassword);
    }

    @DataTableType
    public LinkExternalAccountInfo linkExternalAccount(Map<String,String> entry){

        String  openBankingProviders = entry.get(" openBankingProviders ");
        String username = entry.get("username");
        String password = entry.get("password");

        return new LinkExternalAccountInfo(openBankingProviders,username,password);

    }

    @DataTableType
    public DepositInfo depositInfo (Map<String,String> entry){

        String accountName = entry.get("accountName");
        double balance = Double.parseDouble(entry.get("balance"));
        String depositAmount = entry.get("depositAmount");
        String newBalance = entry.get("newBalance");


        return new DepositInfo(accountName,balance,depositAmount,newBalance);

// hi ethan was here and nathan too simbaaaaaaaaaaaaa


    }
}
