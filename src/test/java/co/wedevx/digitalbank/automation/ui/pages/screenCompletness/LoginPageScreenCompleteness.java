package co.wedevx.digitalbank.automation.ui.pages.screenCompletness;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class LoginPageScreenCompleteness  {
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
    @FindBy(css = "div.container")
    WebElement background;

    @CacheLookup
    @FindBy(css = "img.align-content")
    WebElement logo;

    @CacheLookup
    @FindBy(css = "div.login-form")
    WebElement loginForm;

    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'User Name')]")
    WebElement labelUserName;

    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'Password')]")
    WebElement labelPassword;


    public LoginPageScreenCompleteness(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateBackgroundColor() {

        String actualBackgroundColor = background.getCssValue("color");
        String expectedBackgroundColor = "rgb(33, 37, 41)";
        Assert.assertEquals(expectedBackgroundColor, actualBackgroundColor, "Background color doesn't much");
        Reporter.log("Background color is " + background.getCssValue("color"));


    }

    public void validateLogo() {

        assertTrue(logo.isDisplayed(), "Logo is not displayed");
        Reporter.log("Logo is displayed");
        assertEquals(logo.getLocation(), logo.getLocation(), "Logo location doesn't match");
        Reporter.log("Logo location is " + logo.getLocation());
        assertEquals(logo.getSize(), logo.getSize(), "Logo size doesn't match");
        Reporter.log("Logo size is " + logo.getSize());
    }

    public void validateLoginForm() {

        assertTrue(loginForm.isDisplayed());
        Reporter.log("Login Form is displayed");
        String actualLoginFormColor = loginForm.getCssValue("color");
        String expectedLoginFormColor = "rgb(33, 37, 41)";
        Assert.assertEquals(expectedLoginFormColor, actualLoginFormColor, "Login Form color doesn't much");
        Reporter.log("Login Form background color is " + loginForm.getCssValue("color"));
        Assert.assertEquals(loginForm.getSize(), loginForm.getSize(), "Login Form size doesn't much");
        Reporter.log("Login Form size is " + loginForm.getSize());
        Assert.assertEquals(loginForm.getLocation(), loginForm.getLocation(), "Login Form size doesn't much");
        Reporter.log("Login Form location is " + loginForm.getLocation());

    }

    public void validateLabelUserName() {

        assertTrue(labelUserName.isDisplayed(), "User Name label is not displayed");
        Reporter.log("Label USER NAME is displayed " + labelUserName.isDisplayed());
        assertEquals("USER NAME", labelUserName.getText(), "Label User Name text doesn't much");
        Reporter.log("Label USER NAME text is " + labelUserName.getText());
        assertEquals(labelUserName.getCssValue("color"), labelUserName.getCssValue("color"), " User Name color text doesn't much");
        Reporter.log("Label USER NAME  text color is " + labelUserName.getCssValue("color"));

    }

    public void validateLabelPassword() {

        assertTrue(labelPassword.isDisplayed(), "Password label is not displayed");
        Reporter.log("Label PASSWORD is displayed " + labelPassword.isDisplayed());
        assertEquals("PASSWORD", labelPassword.getText(), "Label PASSWORD text doesn't much");
        Reporter.log("Label PASSWORD text is " + labelPassword.getText());
        assertEquals(labelPassword.getCssValue("color"), labelPassword.getCssValue("color"), " Label Password color text doesn't much");
        Reporter.log("Label PASSWORD  text color is " + labelPassword.getCssValue("color"));
    }

    public void validateRadioButton() {

        assertTrue(rememberMeBtn.isDisplayed(),"Remember me button is not displayed");
        Reporter.log("Remember me button is displayed " + rememberMeBtn.isDisplayed());
        assertTrue(rememberMeBtn.isEnabled());
        Reporter.log("Remember me button is enabled " + rememberMeBtn.isEnabled());
        assertFalse(rememberMeBtn.isSelected(),"Remember me button is selected failed");
        Reporter.log("Remember me button is not selected");
        rememberMeBtn.click();
        assertTrue(rememberMeBtn.isSelected(),"Remember me button is selected failed");
        Reporter.log("Remember me button is selected " + rememberMeBtn.isSelected());
        //System.out.println("Remember me radio button text is " + rememberMeBtnText.getText());
        //System.out.println("Remember me text color is " + rememberMeBtnText.getCssValue("color"));

    }

    public void validateSignInButton() {

        assertTrue(signInBtn.isDisplayed(),"Sign in button is not displayed");
        Reporter.log("Sign in button is displayed " + signInBtn.isDisplayed());
        assertEquals(signInBtn.getSize(),signInBtn.getSize(),"Sign in button size doesn't match");
        Reporter.log("Sign in button size is " + signInBtn.getSize());
        assertEquals(signInBtn.getCssValue("color"),signInBtn.getCssValue("color"),"Sign in button color doesn't match");
        Reporter.log("Sign in button color is " + signInBtn.getCssValue("color"));
        assertEquals(signInBtn.getLocation(),signInBtn.getLocation(),"Sign in button location doesn't match");
        Reporter.log("Sign in button location is " + signInBtn.getLocation());
        assertEquals(signInBtn.getText(),signInBtn.getText(),"Sign in button text doesn't match");
        Reporter.log("Sign in button text is " + signInBtn.getText());
    }

    public void validateDontHaveAccount() {

        assertTrue(dontHaveAccount.isDisplayed(),"Don't have account is not displayed");
        Reporter.log("Don't have account is displayed " + dontHaveAccount.isDisplayed());
        assertEquals(dontHaveAccount.getCssValue("color"),dontHaveAccount.getCssValue("color"),"Don't have account Text color doesn't match");
        Reporter.log("Don't have account text color is " + dontHaveAccount.getCssValue("color"));
        assertEquals(dontHaveAccount.getText(),dontHaveAccount.getText(),"Don't have Account Text doesn't match");
        Reporter.log("Don't have account text is " + dontHaveAccount.getText());
        assertEquals(dontHaveAccount.getLocation(),dontHaveAccount.getLocation(),"Don't Have Account location doesn't match");
        Reporter.log("Don't have account location is " + dontHaveAccount.getLocation());
    }

    public void validateSignUpButton() {

        assertTrue(signUpBtn.isDisplayed(),"Sign Up button is not displayed");
        Reporter.log("Sign up here is displayed " + signUpBtn.isDisplayed());
        assertEquals(signUpBtn.getText(),signUpBtn.getText(),"Sign up button text doesn't match");
        Reporter.log("Sign up here text is " + signUpBtn.getText());
        assertEquals(signUpBtn.getCssValue("color"),signUpBtn.getCssValue("color"),"Sign up button text color doesn't match");
        Reporter.log("Sign up here text color is " + signUpBtn.getCssValue("color"));
        assertEquals(signUpBtn.getLocation(),signUpBtn.getLocation(),"Sign Up location doesn't match");
        Reporter.log("Sign up here text location is " + signUpBtn.getLocation());


    }

}
