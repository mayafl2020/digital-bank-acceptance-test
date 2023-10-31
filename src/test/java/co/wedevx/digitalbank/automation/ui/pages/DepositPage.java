package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.DepositInfo;
import co.wedevx.digitalbank.automation.ui.models.NewSavingsAccountInfo;
import co.wedevx.digitalbank.automation.ui.utils.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositPage extends BaseMenuPage {

    private WebDriver driver;


    @CacheLookup
    @FindBy(id = "selectedAccount")
    WebElement selectAccount;

    @CacheLookup
    @FindBy(id = "amount")
    WebElement amount;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitBtn;

    public DepositPage(WebDriver driver) {

        super(driver);
    }

   public void accountWithABalance(List<DepositInfo> depositList){

       DepositInfo depositData = depositList.get(0);
       System.out.println(depositData.getAccountName());
       System.out.println(depositData.getBalance());

   }
    public void clickDepositMenu() {

        depositMenu.click();
    }

    public void makeDeposit(List<DepositInfo> depositList) {


        System.out.println("done2");

        Select select = new Select(selectAccount);
        select.selectByVisibleText("Elon Musk Second Checking (Standard Checking)");
        DepositInfo depositData = depositList.get(0);
        amount.sendKeys(depositData.getDepositAmount());

//        List<WebElement> allOPt = select.getOptions();
//        for(WebElement elem : allOPt) {
//            System.out.println(elem.getText());
//        }

    }

    public void clickSubmit() {

        submitBtn.click();
    }

    public void verifyDepositBalance() {



    }


}
