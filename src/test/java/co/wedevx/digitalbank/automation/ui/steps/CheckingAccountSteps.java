package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.models.Transactions;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.NewCheckingPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckingAccountSteps {


    final co.wedevx.digitalbank.automation.ui.steps.zipit zipit = new zipit();
    WebDriver driver = Driver.getDriver();

    LoginPage lp;


    @Given("the user logged in as {string} {string}")
    public void the_user_logged_in_as (String email, String password){

        lp = new LoginPage(driver);
        lp.loginWithValidCredentials(email, password);


    }
    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data (List<NewCheckingAccountInfo> newCheckingAccountInfoList){

        zipit.np = new NewCheckingPage(driver);
        zipit.np.createNewCheckingAccount(newCheckingAccountInfoList);
    }
    @Then("the user should see the green {string}")
    public void the_user_should_see_the_green (String successfullyCreatedMsg){

        zipit.np = new NewCheckingPage(driver);
        zipit.np.succesfulMessage(successfullyCreatedMsg);

    }
    @Then("the user should see newly added card")
    public void the_user_should_see_newly_added_card (List<AccountCard> accountCardList){

        zipit.np = new NewCheckingPage(driver);
        zipit.np.newCardValidation(accountCardList);

    }
    @Then("the user should see the following transactions")
    public void the_user_should_see_the_following_transactions (List<Transactions> transactionsList){

        zipit.np = new NewCheckingPage(driver);
        zipit.np.transactionsValidation(transactionsList);

    }

}
