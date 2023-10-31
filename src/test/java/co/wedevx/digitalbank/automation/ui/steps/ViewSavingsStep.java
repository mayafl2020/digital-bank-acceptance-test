package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.Transactions;
import co.wedevx.digitalbank.automation.ui.pages.NewCheckingPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewSavingsPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewSavingsStep {

    WebDriver driver = Driver.getDriver();
    ViewSavingsPage vp;
    NewCheckingPage np;

    @When("the user clicks on the savings menu button")
    public void the_user_clicks_on_the_savings_menu_button() {
       vp = new ViewSavingsPage(driver);
       vp.clickSavingsMenuBtn();
    }
    @When("the user clicks on savings view button")
    public void the_user_clicks_on_savings_view_button() {
        vp = new ViewSavingsPage(driver);
        vp.clickViewSavings();
    }
    @Then("the user is on the view savings page")
    public void the_user_is_on_the_view_savings_page() {
        vp = new ViewSavingsPage(driver);
        vp.verifySavingsPage();

    }
    @Then("the user should see saving account cards with the following info")
    public void the_user_should_see_saving_account_cards_with_the_following_info(List<AccountCard> accountCardList) {
        np = new NewCheckingPage(driver);
        np.newCardValidation(accountCardList);

    }

    @And("the user should see the transactions")
    public void theUserShouldSeeTheTransactions(List<Transactions> transactionsList) {
        np = new NewCheckingPage(driver);
        np.transactionsValidation(transactionsList);

    }
}
