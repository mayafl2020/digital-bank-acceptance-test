package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.LinkExternalAccountInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinkExternalAccountPage extends BaseMenuPage{

    private WebDriver driver;




    @CacheLookup
    @FindBy(id = "username")
    WebElement username;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    public LinkExternalAccountPage(WebDriver driver){

        super(driver);
    }

    public void linkExternalAccount(List<LinkExternalAccountInfo> linkExternalAccountList){

        LinkExternalAccountInfo dataEntry = linkExternalAccountList.get(0);

        externalBtn.click();
        linkExternalBtn.click();
        username.sendKeys(dataEntry.getUsername());
        password.sendKeys(dataEntry.getPassword());

    }
}
