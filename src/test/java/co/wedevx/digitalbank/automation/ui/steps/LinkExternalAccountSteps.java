package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.LinkExternalAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.LinkExternalAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LinkExternalAccountSteps {

    WebDriver driver = Driver.getDriver();
    LinkExternalAccountPage leap;

    @When("the user add open Banking Account with the following data")
    public void the_user_add_open_banking_account_with_the_following_data(List<LinkExternalAccountInfo> linkExternalAccountList) {

        leap = new LinkExternalAccountPage(driver);
        leap.linkExternalAccount(linkExternalAccountList);

    }
    @Then("the user should see successfull message")
    public void the_user_should_see_successfull_message() {

        System.out.println("Successfully linked");

    }
}
