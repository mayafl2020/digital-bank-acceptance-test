package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import co.wedevx.digitalbank.automation.ui.models.RegistrationInfo;
import org.openqa.selenium.WebDriver;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;


public class RegistrationStep {

    RegistrationPage sp = new RegistrationPage(getDriver());

    @Given("User navigates to Digital Bank signup page")
    public void userNavigatesToDigitalBankSignupPage() {

        getDriver().get(ConfigReader.getPropertiesvalue("digitalbank.registrationpageurl"));
        assertEquals("Digital Bank",getDriver().getTitle(),"registration page title mismatch");

    }

    @When("the user creates a new account with the following data")
    public void theUserCreatesANewAccountWithTheFollowingData(List<Map<String,String>> registrationTestDataListMap) {

        sp = new RegistrationPage(getDriver());
        sp.fillOutRegistrationPage(registrationTestDataListMap);
    }

    @Then("the user should see the message  {string}")
    public void theUserShouldSeeTheMessage(String expectedSuccessMessage) {

        assertEquals(expectedSuccessMessage,sp.getMessage(),"Success message mismatch");
    }


    @Then("the user should see the following {string} required field error message {string}")
    public void theUserShouldSeeTheFollowingRequiredFieldErrorMessage(String fieldName, String expectedErrorMessage) {

        String actualErrorMessage = sp.getRequiredFieldErrorMsg(fieldName);
        assertEquals(expectedErrorMessage,actualErrorMessage,"the error message of required " + fieldName + " field mismatch");

    }


    @And("the user clicked on the submit button")
    public void theUserClickedOnTheSubmitButton() {

        sp = new RegistrationPage(getDriver());
        sp.clickNextButton();
    }

    @Then("the following user info should be saved in the db")
    public void theFollowingUserInfoShouldBeSavedInTheDb(List<Map<String,String>> expectedUserInfoInDbList) {

                 Map<String,String> expectedUserInfoMap = expectedUserInfoInDbList.get(0);

                 String queryUserTable = String.format("select * from users where username = '$s'", expectedUserInfoMap.get("email"));
                String queryUserProfile = String.format("select * from user_profile where email_address = '$s'", expectedUserInfoMap.get("email"));



                 List<Map<String, Object>> actualUserinfoList =  DBUtils.runSQLSelectQuery(queryUserTable);
                 List<Map<String, Object>> actualUserProfileInfoList = DBUtils.runSQLSelectQuery(queryUserProfile);

                 assertEquals(1,actualUserinfoList.size(), "registration generated unexpected number of users");
                 assertEquals(1,actualUserProfileInfoList.size(), "registration generated unexpected number of users");

                 Map<String, Object> actualUserInfoMap = actualUserinfoList.get(0);
                 Map<String, Object> actualUserProfileInfoMap = actualUserProfileInfoList.get(0);

                 assertEquals(expectedUserInfoMap.get("title"),actualUserProfileInfoMap.get("title"), "registration generated wrong title");
                 assertEquals(expectedUserInfoMap.get("firstName"),actualUserProfileInfoMap.get("first_name"), "registration generated wrong first name");
                 assertEquals(expectedUserInfoMap.get("lastName"),actualUserProfileInfoMap.get("last_name"), "registration generated wrong last name");
                 assertEquals(expectedUserInfoMap.get("gender"),actualUserProfileInfoMap.get("gender"), "registration generated wrong gender");
                 assertEquals(expectedUserInfoMap.get("dateOfBirth"),actualUserProfileInfoMap.get("dob"), "registration generated wrong date of birth");
                 assertEquals(expectedUserInfoMap.get("ssn"),actualUserProfileInfoMap.get("ssn"), "registration generated wrong ssn");
                 assertEquals(expectedUserInfoMap.get("email"),actualUserProfileInfoMap.get("email_address"), "registration generated wrong email address");
                 assertEquals(expectedUserInfoMap.get("address"),actualUserProfileInfoMap.get("address"), "registration generated wrong address");
                 assertEquals(expectedUserInfoMap.get("locality"),actualUserProfileInfoMap.get("locality"), "registration generated wrong locality");
                 assertEquals(expectedUserInfoMap.get("region"),actualUserProfileInfoMap.get("region"), "registration generated wrong region");
                 assertEquals(expectedUserInfoMap.get("postalCode"),actualUserProfileInfoMap.get("postal_code"), "registration generated postal_code");
                 assertEquals(expectedUserInfoMap.get("country"),actualUserProfileInfoMap.get("country"), "registration generated wrong country");
                 assertEquals(expectedUserInfoMap.get("homePhone"),actualUserProfileInfoMap.get("home_phone"), "registration generated wrong home phone");
                 assertEquals(expectedUserInfoMap.get("mobilePhone"),actualUserProfileInfoMap.get("mobile_phone"), "registration generated wrong mobile phone");
                 assertEquals(expectedUserInfoMap.get("workPhone"),actualUserProfileInfoMap.get("work_phone"), "registration generated wrong  work phone");


    }


    @Given("The user with {string} is not in DB")
    public void theUserWithIsNotInDB(String email) {

        String queryForUserProfile = String.format("DELETE from user_profile where email_address='%s'",email);
        String queryForUsers = String.format("DELETE from users where username ='%s'",email);
        DBUtils.runSQLUpdateQuery(queryForUserProfile);
        DBUtils.runSQLUpdateQuery(queryForUsers);
    }


}
