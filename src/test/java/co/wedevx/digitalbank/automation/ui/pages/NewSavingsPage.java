package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.NewSavingsAccountInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewSavingsPage  extends BaseMenuPage{

    private WebDriver driver;



    @CacheLookup
    @FindBy(id = "new-savings-menu-item")
    WebElement newSavingsBtn;

    @CacheLookup
    @FindBy(id = "name")
    WebElement accountName;

    @CacheLookup
    @FindBy(id = "openingBalance")
    WebElement openingBalanceTextBox;

    @CacheLookup
    @FindBy(id = "newSavingsSubmit")
    WebElement newSavingsSubmitBtn;

    @CacheLookup
    @FindBy(id = "new-account-msg")
    WebElement newAccountMessage;

    @CacheLookup
    @FindBy(id = "Savings" )
    WebElement savingsRadioBtn;

    @CacheLookup
    @FindBy(id = "Individual" )
    WebElement individualOwnershipRadioBtn;



    public NewSavingsPage(WebDriver driver) {
      super(driver);
    }

    public void createNewSavingsAccount(List<NewSavingsAccountInfo> newSavingsList) {

        NewSavingsAccountInfo testDataForOneSavingsAccount = newSavingsList.get(0);
        savingsMenu.click();
        newSavingsBtn.click();
        savingsRadioBtn.click();
        individualOwnershipRadioBtn.click();
        accountName.sendKeys(testDataForOneSavingsAccount.getAccountName());
        openingBalanceTextBox.sendKeys(String.valueOf(testDataForOneSavingsAccount.getInitialDeposit()));
        newSavingsSubmitBtn.click();

    }

    public void succesfulMessage(String successfullyCreatedMsg) {

        assertEquals(successfullyCreatedMsg , newAccountMessage.getText(), "Successfully created text didn't match");
        System.out.println("passed");
    }
}
