package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.Transactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewSavingsPage extends BaseMenuPage{


    public ViewSavingsPage(WebDriver driver) {
        super(driver);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@id ='firstRow']/div")
    List<WebElement> allFirstRowDivs;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='firstRow']/child::div[7]")
    WebElement cardInfo ;

    @CacheLookup
    @FindBy(xpath = "//tr[@class ='odd']/td")
    List<WebElement> transactionTable;


    public void clickSavingsMenuBtn(){

        savingsMenu.click();
    }

    public void clickViewSavings(){

        viewSavingsMenu.click();
    }

    public void verifySavingsPage(){

        System.out.println(driver.getTitle());

    }
    public void viewAccountCard(List<AccountCard> accountCardList){

//        for (WebElement card : allFirstRowDivs) {
//            System.out.println(card.getText());
//        }
        WebElement lastAccountCard = allFirstRowDivs.get(allFirstRowDivs.size()-1);
        System.out.println(lastAccountCard.getText());

        System.out.println("text " + cardInfo.getText());
    }

    public void transactionsValidation(List<Transactions> transactionsList) {

        System.out.println("Transactions");

//        for (WebElement info : transactionTable) {
//            System.out.println(info.getText());
//        }

// webelement returns data input from transaction table,create global findby for each column 0-5,name it as the name of a column
        WebElement trns = driver.findElement(By.xpath ("//tr[@class ='odd']/child::td[5]"));
        System.out.println(trns.getText());


    }

    }

