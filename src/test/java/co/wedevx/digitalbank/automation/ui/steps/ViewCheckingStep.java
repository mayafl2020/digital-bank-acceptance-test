package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.Transactions;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewCheckingPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewCheckingStep {

    WebDriver driver = Driver.getDriver();
    LoginPage lp;
    ViewCheckingPage vp;

    @Given("User logged in {string} {string}")
    public void user_logged_in(String email, String password) {
       lp = new LoginPage(driver);
       lp.loginWithValidCredentials(email,password);
    }
    @When("User clicks on checking menu button")
    public void user_clicks_on_checking_menu_button() {
        vp = new ViewCheckingPage(driver);
        vp.clickCheckingMenu();

    }
    @When("User clicks on view checking")
    public void user_clicks_on_view_checking() {
         vp = new ViewCheckingPage(driver);
         vp.clickViewChecking();
    }
    @Then("User is on View Checking page")
    public void user_is_on_view_checking_page() {
        vp =  new ViewCheckingPage(driver);
        vp.verifyPageTitle();
        assertEquals("Digital Bank",driver.getTitle(),"Title mismatch");
    }
    @Then("User can see checking accounts info")
    public void user_can_see_checking_accounts_info(List<AccountCard> expectedAccountCardList) {
       vp = new ViewCheckingPage(driver);
       vp.viewAccountCard(expectedAccountCardList);
        WebElement firstAccountCardInfo = driver.findElement(By.xpath("//div[@id ='firstRow']/child::div[1]"));
        String actualResult = firstAccountCardInfo.getText();
        System.out.println(actualResult);
        String actualAccountName = actualResult.substring(0,actualResult.indexOf("\n")).trim();
        String actualAccountType = actualResult.substring(actualResult.indexOf("Account"),actualResult.indexOf("Ownership")).trim();
        String actualOwnership = actualResult.substring(actualResult.indexOf("Ownership"),actualResult.indexOf("Account Number:")).trim();
        String actualAccountNumber = actualResult.substring(actualResult.indexOf("Account Number:"),actualResult.indexOf("Interest Rate")).trim();
        String actualInterestRate = actualResult.substring(actualResult.indexOf("Interest Rate"),actualResult.indexOf("Balance:")).trim();
        String actualBalance = actualResult.substring(actualResult.indexOf("Balance:")).trim();

        AccountCard expectedAccountInfo = expectedAccountCardList.get(0);

        assertEquals(expectedAccountInfo.getAccountName(),actualAccountName,"Account Name mismatch");
        assertEquals("Account: "+ expectedAccountInfo.getAccountType(),actualAccountType,"Account type mismatch");
        assertEquals("Ownership: " + expectedAccountInfo.getOwnership(),actualOwnership,"Ownership mismatch");
        assertEquals("Account Number: " + expectedAccountInfo.getAccountNumber(),actualAccountNumber,"Account number mismatch");
        assertEquals("Interest Rate: " + expectedAccountInfo.getInterestRate(),actualInterestRate,"Interest rate mismatch");

        String expectedBalance = String.format("%.2f",expectedAccountInfo.getBalance());
        assertEquals("Balance: $" + expectedBalance,actualBalance,"Balance mismatch");

    }
    @Then("User can see Transaction info")
    public void user_can_see_transaction_info(List<Transactions> expectedTransactionsList) {

        vp = new ViewCheckingPage(driver);
        vp.transactionsValidation(expectedTransactionsList);
        WebElement firstRowOfTransactions = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr"));
        List<WebElement> firsRowColumns = firstRowOfTransactions.findElements(By.xpath("td"));

        String actualCategory = firsRowColumns.get(1).getText();
        String actualDescription = firsRowColumns.get(2).getText();
        double actualAmount = Double.parseDouble(firsRowColumns.get(3).getText().substring(1));
        double actualBalance = Double.parseDouble(firsRowColumns.get(4).getText().substring(1));

        Transactions expectedTransaction = expectedTransactionsList.get(0);

        assertEquals(expectedTransaction.getCategory(),actualCategory,"mismatch category");
        assertEquals(expectedTransaction.getDescription(),actualDescription,"mismatch description");
        assertEquals(expectedTransaction.getAmount(),actualAmount,"mismatch amount");
        assertEquals(expectedTransaction.getBalance(),actualBalance,"mismatch balance");
    }

}
