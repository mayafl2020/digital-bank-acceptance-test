package co.wedevx.digitalbank.automation.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import co.wedevx.digitalbank.automation.ui.models.NewSavingsAccountInfo;
import org.openqa.selenium.WebDriver;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.NewSavingsPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;

import java.util.List;

public class NewSavingsStep {

    WebDriver driver = Driver.getDriver();

    LoginPage lp;
    NewSavingsPage nsp;

    @When("the user creates a new savings account with the following data")
    public void the_user_creates_a_new_savings_account_with_the_following_data(List<NewSavingsAccountInfo> newSavingsList) {
       nsp =new NewSavingsPage(driver);
       nsp.createNewSavingsAccount(newSavingsList);

    }
    @Then("user should see a successful message {string}")
    public void user_should_see_a_successful_message(String message) {
        nsp =new NewSavingsPage(driver);
        nsp.succesfulMessage(message);
    }

}
