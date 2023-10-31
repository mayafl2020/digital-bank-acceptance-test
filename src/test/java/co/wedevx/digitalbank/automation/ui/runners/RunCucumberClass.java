package co.wedevx.digitalbank.automation.ui.runners;

import org.junit.platform.suite.api.*;
import org.testng.ISuite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ui/features/loginAndRegistration")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME , value = "features")
@ConfigurationParameter(key=PLUGIN_PROPERTY_NAME , value = "pretty,html:target/results.html")
@ExcludeTags("ignore")

public class RunCucumberClass {

}
