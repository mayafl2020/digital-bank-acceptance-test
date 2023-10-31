package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage{

    private WebDriver driver;

    @CacheLookup
    @FindBy(id = "username")
    WebElement username;

    @CacheLookup
    @FindBy(id = "password")
    WebElement pswrd;

    @CacheLookup
    @FindBy(id = "remember-me")
    WebElement rememberMeBtn;

    @CacheLookup
    @FindBy(css = "#text")
    WebElement rememberMeBtnText;

    @CacheLookup
    @FindBy(xpath = "//button")
    WebElement signInBtn;

    @CacheLookup
    @FindBy(id = "submit")
    WebElement submitBtn;


    @CacheLookup
    @FindBy(xpath = ("//span[@class='badge badge-pill badge-danger']"))
    WebElement errorWord;


    @CacheLookup
    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//img[@alt ='User Avatar']")
    WebElement avatar;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'have account ?')]")
    WebElement dontHaveAccount;

    @CacheLookup
    @FindBy(linkText = "Sign Up Here")
    WebElement signUpBtn;

    @CacheLookup
    @FindBy(css="div.container")
    WebElement background;

    @CacheLookup
    @FindBy(css="img.align-content")
    WebElement logo;

    @CacheLookup
    @FindBy(css="div.login-form")
    WebElement loginForm;

    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'User Name')]")
    WebElement labelUserName;

    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'Password')]")
    WebElement labelPassword;




    public LoginPage(WebDriver driver) {
        super(driver);
    }




    public void loginWithInvalidCredentials(String email, String password) {

        username.clear();
        username.sendKeys(email);

        pswrd.clear();
        pswrd.sendKeys(password);

        rememberMeBtn.click();

        submitBtn.click();
    }

    public void failureMessage() {

        String actualResult = errorMessage.getText();
        String expectedResult = "Error Invalid credentials or access not granted due to user account status or an existing user session.\n" +
                "×";
        assertEquals(actualResult, expectedResult);
        System.out.println("Error message is " + errorMessage.getText());


    }

    public void loginWithValidCredentials(String email, String password) {

        username.clear();
        username.sendKeys(email);

        pswrd.clear();
        pswrd.sendKeys(password);

        rememberMeBtn.click();

        submitBtn.click();
    }
        public void successfullyLoggedIn() {

            if (avatar.isDisplayed()) {

                System.out.println("Successfully logged in");
            }
//        logout.click();

        }



    }
