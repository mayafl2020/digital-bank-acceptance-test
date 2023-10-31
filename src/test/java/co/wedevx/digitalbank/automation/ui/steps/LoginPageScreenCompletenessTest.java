package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.screenCompletness.LoginPageScreenCompleteness;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageScreenCompletenessTest {
        WebDriver driver = Driver.getDriver();

        LoginPageScreenCompleteness lpsc;


        @BeforeTest
        public void url() {
            driver.get("http://mayafarberov.mydevx.com/bank/login");
        }

        @Test
        public void backgroundColor() {
            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateBackgroundColor();
        }

        @Test
        public void validateLogo() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateLogo();
        }

        @Test
        public void validateLoginForm() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateLoginForm();
        }

        @Test
        public void validateLabelUserName() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateLabelUserName();
        }


        @Test
        public void validateLabelPassword() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateLabelPassword();
        }

        @Test
        public void validateRadioButton() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateRadioButton();
        }

        @Test
        public void validateSignInButton() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateSignInButton();
        }

        @Test
        public void validateDontHaveAccount() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateDontHaveAccount();
        }

        @Test
        public void validateSignUpButton() {

            lpsc = new LoginPageScreenCompleteness(driver);
            lpsc.validateSignUpButton();
        }
    }


