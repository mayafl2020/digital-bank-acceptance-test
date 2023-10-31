package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.RegistrationInfo;
import co.wedevx.digitalbank.automation.ui.utils.MockData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegistrationPage extends BasePage {

    private WebDriver driver;
    MockData mockData = new MockData();

    @CacheLookup
    @FindBy(id = "title")
    WebElement titleId;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),' Sign Up Here')]")
    WebElement signUpHereBtn;

    @CacheLookup
    @FindBy(id = "firstName")
    WebElement firstNameTxt;

    @CacheLookup
    @FindBy(id = "lastName")
    WebElement lastNameTxt;

    @CacheLookup
    @FindBy(id = "dob")
    WebElement dobTxt;

    @CacheLookup
    @FindBy(id = "ssn")
    WebElement ssnTxt;

    @CacheLookup
    @FindBy(id = "emailAddress")
    WebElement emailTxt;

    @CacheLookup
    @FindBy(id = "password")
    WebElement pswrdTxt;

    @CacheLookup
    @FindBy(id = "confirmPassword")
    WebElement confirmPswrdTxt;

    @CacheLookup
    @FindBy(xpath = ("//input[@value='M']"))
    WebElement male;

    @CacheLookup
    @FindBy(xpath = ("//input[@value='F']"))
    WebElement female;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextBtn;

    @CacheLookup
    @FindBy(id = "address")
    WebElement addressTxt;

    @CacheLookup
    @FindBy(id = "locality")
    WebElement localityTxt;

    @CacheLookup
    @FindBy(id = "region")
    WebElement regionTxt;

    @CacheLookup
    @FindBy(id = "postalCode")
    WebElement postalCodeTxt;

    @CacheLookup
    @FindBy(id = "country")
    WebElement countryTxt;

    @CacheLookup
    @FindBy(id = "homePhone")
    WebElement homePhoneTxt;

    @CacheLookup
    @FindBy(id = "mobilePhone")
    WebElement mobilePhoneTxt;

    @CacheLookup
    @FindBy(id = "workPhone")
    WebElement workPhoneTxt;

    @CacheLookup
    @FindBy(id = "agree-terms")
    WebElement agreeTerms;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    WebElement registerBtn;

    @CacheLookup
//    @FindBy(xpath="//span[contains(text(),'Registration Successful. Please Login.')]")
    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']")
    WebElement successfulRegistrationMessage;


    public RegistrationPage(WebDriver driver) {

        super(driver);
    }


    public void fillOutRegistrationPage(List<Map<String, String>> registrationPageTestDataListOfMap) {



        Select titleSelect = new Select(titleId);
        Map<String, String> firstRow = registrationPageTestDataListOfMap.get(0);
        if (firstRow.get("title") != null) {
            titleSelect.selectByVisibleText(firstRow.get("title"));
        }
        if (firstRow.get("firstName") != null) {
            firstNameTxt.sendKeys(firstRow.get("firstName"));
        }
        if (firstRow.get("lastName") != null) {
            lastNameTxt.sendKeys(firstRow.get("lastName"));
        }
        if (firstRow.get("gender") != null) {
            if (firstRow.get("gender").equalsIgnoreCase("M")) {
                male.click();
            } else if (firstRow.get("gender").equalsIgnoreCase("F")) {
                female.click();
            } else {
                System.out.println("Wrong Gender provided");
            }
        }
        if (firstRow.get("dateOfBirth") != null) {
            dobTxt.sendKeys(firstRow.get("dateOfBirth"));
        }
        if (firstRow.get("ssn") != null) {

            ssnTxt.sendKeys(firstRow.get("ssn"));
            }
            if (firstRow.get("email") != null) {

                emailTxt.sendKeys(firstRow.get("email"));
                }

                if (firstRow.get("password") != null) {
                    pswrdTxt.sendKeys(firstRow.get("password"));
                    confirmPswrdTxt.sendKeys(firstRow.get("password"));
                }
                nextBtn.click();
                if (addressTxt.isDisplayed()) {

                    if (firstRow.get("address") != null) {
                        addressTxt.sendKeys(firstRow.get("address"));
                    }
                    if (firstRow.get("locality") != null) {
                        localityTxt.sendKeys(firstRow.get("locality"));
                    }
                    if (firstRow.get("region") != null) {
                        regionTxt.sendKeys(firstRow.get("region"));
                    }
                    if (firstRow.get("postalCode") != null) {
                        postalCodeTxt.sendKeys(firstRow.get("postalCode"));
                    }
                    if (firstRow.get("country") != null) {
                        countryTxt.sendKeys(firstRow.get("country"));
                    }
                    if (firstRow.get("homePhone") != null) {
                        homePhoneTxt.sendKeys(firstRow.get("homePhone"));
                    }
                    if (firstRow.get("mobilePhone") != null) {
                        mobilePhoneTxt.sendKeys(firstRow.get("mobilePhone"));
                    }
                    if (firstRow.get("workPhone") != null) {
                        workPhoneTxt.sendKeys(firstRow.get("workPhone"));
                    }

//                    if (firstRow.get("termsCheckMark") != null) {
//                        if (firstRow.get("termsCheckMark").equalsIgnoreCase("true")) {
                            agreeTerms.click();
//                        }
                        registerBtn.click();
                    }

                }
//            }


//    public void createNewAccount(List<RegistrationInfo> newAccountList){
//
//        RegistrationInfo testDataForOneAccount = newAccountList.get(0);
//
//        signUpHereBtn.click();
//        Select select = new Select(titleId);
//
//        if(testDataForOneAccount.getTitle().equals("Mr.")) {
//            select.selectByIndex(1);
//        }
//        else if (testDataForOneAccount.getTitle().equals("Ms.")){
//            select.selectByIndex(2);
//        }
//        else if(testDataForOneAccount.getTitle().equals("Mrs.")){
//            select.selectByIndex(3);
//        }
//        else {
//            System.out.println("Unable to click title");
//        }
//
//        // doesn't work this way select.selectByValue(testDataForOneAccount.getTitle());
//        firstNameTxt.sendKeys(testDataForOneAccount.getFirstName());
//        lastNameTxt.sendKeys(testDataForOneAccount.getLastName());
//        WebElement gender = driver.findElement(By.xpath("//input[@value ='M']"));
//        gender.click();
//        dobTxt.sendKeys(String.valueOf(testDataForOneAccount.getDateOfBirth()));
//        ssnTxt.sendKeys(String.valueOf(testDataForOneAccount.getSsn()));
//        emailTxt.sendKeys(testDataForOneAccount.getEmail());
//        pswrdTxt.sendKeys(testDataForOneAccount.getPassword());
//        confirmPswrdTxt.sendKeys(testDataForOneAccount.getConfirmPassword());
//        nextBtn.click();

//        addressTxt.sendKeys(firstRow.get("address"));
//        localityTxt.sendKeys(firstRow.get("locality"));
//        regionTxt.sendKeys(firstRow.get("region"));
//        postalCodeTxt.sendKeys(firstRow.get("postalCode"));
//        countryTxt.sendKeys(firstRow.get("country"));
//        homePhoneTxt.sendKeys(firstRow.get("homePhone"));
//        mobilePhoneTxt.sendKeys(firstRow.get("mobilePhone"));
//        workPhoneTxt.sendKeys(firstRow.get("workPhone"));

//        agreeTerms.click();
//        registerBtn.click();
//    }

            public String getMessage () {
                return successfulRegistrationMessage.getText().substring(0, successfulRegistrationMessage.getText().lastIndexOf("."));
            }

            public String getRequiredFieldErrorMsg(String fieldName) {

                switch (fieldName.toLowerCase()) {
                    case "title":
                        return titleId.getAttribute("validationMessage");
                    case "firstname":
                        return firstNameTxt.getAttribute("validationMessage");
                    case "lastname":
                        return lastNameTxt.getAttribute("validationMessage");
                    case "gender":
                        return male.getAttribute("validationMessage");
                    case "dateofbirth":
                        return dobTxt.getAttribute("validationMessage");
                    case "ssn":
                        return ssnTxt.getAttribute("validationMessage");
                    case "email":
                        return emailTxt.getAttribute("validationMessage");
                    case "password":
                        return pswrdTxt.getAttribute("validationMessage");
                    case "confirmpassword":
                        return confirmPswrdTxt.getAttribute("validationMessage");
                    case "address":
                        return addressTxt.getAttribute("validationMessage");

                    case " locality ":
                        return localityTxt.getAttribute("validationMessage");
                    case "region ":
                        return regionTxt.getAttribute("validationMessage");
                    case "postalcode ":
                        return postalCodeTxt.getAttribute("validationMessage");
                    case "country":
                        return countryTxt.getAttribute("validationMessage");
                    case "homephone ":
                        return homePhoneTxt.getAttribute("validationMessage");
                    case " mobilephone":
                        return mobilePhoneTxt.getAttribute("validationMessage");
                    case "workphone":
                        return workPhoneTxt.getAttribute("validationMessage");
                    case " termscheckmark":
                        return agreeTerms.getAttribute("validationMessage");
                    default:
                        return null;


                }
            }
         public void clickNextButton(){
             nextBtn.click();
                }

            }


