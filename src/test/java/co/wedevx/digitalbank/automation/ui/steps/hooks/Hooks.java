package co.wedevx.digitalbank.automation.ui.steps.hooks;

import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

public class Hooks {

    @Before("not @Registration")
    public void url() {
        getDriver().get(" http://maya.mydevx.com/bank");
    }

    @Before("@Registration")
    public void establishConnectionToDB() {

        DBUtils.establishConnection();

    }

    @After("@Registration")
    public void closeConnectionToDB() {

        DBUtils.closeConnection();
    }

    //    @After
//    public void afterScenario(Scenario scenario){
//
//        Driver.takeScreenShot(scenario);
//        Driver.closeDriver();
//    }
}
