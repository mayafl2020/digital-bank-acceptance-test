package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.models.Transactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewCheckingPage extends BaseMenuPage {

    private WebDriver driver;
    @CacheLookup
    @FindBy(id = "username")
    WebElement username;

    @CacheLookup
    @FindBy(id = "password")
    WebElement pswrd;

    @CacheLookup
    @FindBy(id = "submit")
    WebElement submitBtn;



    @CacheLookup
    @FindBy(id = "name")
    WebElement accountNameTxt;

    @CacheLookup
    @FindBy(id = "openingBalance")
    WebElement openingBalanceTextBox;

    @CacheLookup
    @FindBy(id = "newCheckingSubmit")
    WebElement submitChBtn;

    @CacheLookup
    @FindBy(id = "new-account-conf-alert")
    WebElement newAccountMessage;

    @CacheLookup
    @FindBy(id = "firstRow")
    WebElement firstRowDiv;

    @CacheLookup
    @FindBy(id = "Standard Checking")
    WebElement standardCheckingAccountRadioBtn;

    @CacheLookup
    @FindBy(id = "Individual")
    WebElement individualOwnershipRadioBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='firstRow']/div")
    List<WebElement> allFirstRowDivs;

    @CacheLookup
    @FindBy(xpath = "//tr[@class ='odd']/td")
    List<WebElement> transactionTable;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='firstRow']/child::div[7]")
    WebElement cardInfo ;


    public NewCheckingPage(WebDriver driver) {
       super(driver);
    }

    public void createNewCheckingAccount(List<NewCheckingAccountInfo> newCheckingAccountInfoList) {

        NewCheckingAccountInfo testDataForONeCheckingAccount = newCheckingAccountInfoList.get(0);
        chekingMenu.click();
        newCheckingAccount.click();
        standardCheckingAccountRadioBtn.click();
        individualOwnershipRadioBtn.click();
        accountNameTxt.sendKeys(testDataForONeCheckingAccount.getAccountName());
        openingBalanceTextBox.sendKeys(String.valueOf(testDataForONeCheckingAccount.getInitialDepositAccount()));
        submitChBtn.click();

    }

    public void succesfulMessage(String successfullyCreatedMsg) {

        assertEquals(successfullyCreatedMsg + "\n×", newAccountMessage.getText(), "Successfully created text didn't match");
        System.out.println("passed");
    }

    public void newCardValidation(List<AccountCard> accountCardList) {


        for (WebElement card : allFirstRowDivs) {
            System.out.println(card.getText());
        }
//        WebElement lastAccountCard = allFirstRowDivs.get(allFirstRowDivs.size()-1);
//        System.out.println(lastAccountCard.getText());

        System.out.println("text " + cardInfo.getText());
    }

    public void transactionsValidation(List<Transactions> transactionsList) {

        System.out.println("Transactions");

        for (WebElement info : transactionTable) {
            System.out.println(info.getText());
        }

// webelement returns data input from transaction table,create global findby for each column 0-5,name it as the name of a column
//        WebElement trns = driver.findElement(By.xpath ("//tr[@class ='odd']/child::td[5]"));
//        System.out.println(trns.getText());


    }

}
