package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.DepositInfo;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.List;



public class DepositStep {

    WebDriver driver = Driver.getDriver();
    DepositPage dp;

    @Given("the following bank accounts with their respective balances")
    public void the_following_bank_accounts_with_their_respective_balances(List<DepositInfo> depositList) {

        dp = new DepositPage(driver);

        dp.accountWithABalance(depositList);


    }
    @When("the user deposits deposit amount to an account")
    public void the_user_deposits_deposit_amount_to_an_account(List<DepositInfo> depositList) {
        dp = new DepositPage(driver);
        dp.clickDepositMenu();
        dp.makeDeposit(depositList);

    }
    @When("the user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() {
        dp = new DepositPage(driver);
        dp.clickSubmit();
    }
    @Then("the user will see the new account balance")
    public void the_user_will_see_the_new_account_balance(List<DepositInfo> depositList) {
        System.out.println("done3");
    }

    @Given("User logged in as {string} {string}")
    public void userLoggedInAs(String arg0, String arg1) {
    }

    @When("User opens view checking account page")
    public void userOpensViewCheckingAccountPage() {
    }

    @Then("User should see account card with the following details")
    public void userShouldSeeAccountCardWithTheFollowingDetails() {
    }

    @And("User should see transaction card details with the following information")
    public void userShouldSeeTransactionCardDetailsWithTheFollowingInformation() {
    }
}
