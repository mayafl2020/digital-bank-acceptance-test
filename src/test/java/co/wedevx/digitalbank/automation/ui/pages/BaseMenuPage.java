package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePage{

    public BaseMenuPage(WebDriver driver){
        super(driver);
    }

    @CacheLookup
    @FindBy(id = "checking-menu")
    protected WebElement chekingMenu;

    @CacheLookup
    @FindBy(id = "new-checking-menu-item")
    protected  WebElement newCheckingAccount;

    @CacheLookup
    @FindBy(id = "deposit-menu-item")
    protected WebElement depositMenu;

    @CacheLookup
    @FindBy(xpath = "//a[@id ='external-accounts-menu']")
    protected WebElement externalBtn;

    @CacheLookup
    @FindBy(xpath = "//a[@id ='link-external-menu-item']")
    protected WebElement linkExternalBtn;

    @CacheLookup
    @FindBy(id = "savings-menu")
    protected WebElement savingsMenu;

    @CacheLookup
    @FindBy( id="view-savings-menu-item")
    protected WebElement viewSavingsMenu;

    @CacheLookup
    @FindBy( id ="view-checking-menu-item")
    protected WebElement viewCheckingMenu;


}
