package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStep {

    WebDriver driver = Driver.getDriver();
    LoginPage lp;




    //    When I create Hook class with @Before, browser opens 7 empty windows.
//    When I use @BeforeAll in Hook class instead, browser opens 1 empty window.
//    When I  use @BeforeAll in LoginSteps it works good
//    When I create NewCheckingSteps and run with @BeforeAll when I have @BeforeAll in LoginSteps as well.Two browser windows open, one is empty and one run the test successfully
//    When I delete @BeforeAll in LoginSteps and run NewCheckingSteps with @BeforeAll it works fine




//    @Given("i'm on login page")
//    public  void i_m_on_login_page(){
//
//        lp = new LoginPage(driver);
//        lpv.pageValidation();
//
//}
    @When("I enter {string} and {string}")
    public void validCredentials (String email, String password) {
        lp = new LoginPage(driver);
        lp.loginWithValidCredentials(email,password);


    }
    @Then("i should get login success message")
    public void i_should_get_login_success_message() {
       lp = new LoginPage(driver);
       lp.successfullyLoggedIn();

    }

    @When("i enter {string} and {string}")
    public void invalidCredentials(String name, String password) {
        lp = new LoginPage(driver);
        lp.loginWithInvalidCredentials(name,password);


    }
    @Then("i should get login failure message")
    public void i_should_get_login_failure_message() {
        lp = new LoginPage(driver);
        lp.failureMessage();

    }




}
