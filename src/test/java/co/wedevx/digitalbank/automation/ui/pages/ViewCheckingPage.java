package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.models.Transactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewCheckingPage extends BaseMenuPage {


    public ViewCheckingPage(WebDriver driver) {
        super(driver);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id ='firstRow']")
    List<WebElement> allFirstRowDivs;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='firstRow']/child::div[1]")
    WebElement firstAccountCardInfos;

    @CacheLookup
    @FindBy(xpath = "//tr[@class ='odd']/td")
    List<WebElement> transactionTable;

    @CacheLookup
    @FindBy(xpath = "//tr[@class ='odd']/child::td[5]")
    WebElement balanceTransaction;

    @CacheLookup
    @FindBy(xpath = "//tbody")
    List<WebElement> allTransactions;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr")
    WebElement lastTransaction;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[2]")
    WebElement secondTransaction;

    public void clickCheckingMenu() {

        chekingMenu.click();
    }

    public void clickViewChecking() {

        viewCheckingMenu.click();
    }

    public void verifyPageTitle() {

        System.out.println(driver.getTitle());
    }

    public void viewAccountCard(List<AccountCard> expectedAccountCardList) {

        System.out.println("Account Card");

//        for (WebElement card : allFirstRowDivs) {
//            System.out.println(card.getText());
//        }

//        WebElement lastAccountCard = allFirstRowDivs.get(allFirstRowDivs.size() - 1);


    }

    public void transactionsValidation(List<Transactions> expectedTransactionsList) {

        System.out.println("Transactions");
    }

}

