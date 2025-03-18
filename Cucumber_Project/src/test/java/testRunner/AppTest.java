package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,
features = {"featurefiles"}
,monochrome = true,
tags = ("@Validlogin not, @MultipleData not, @AddEmp"),glue = {"stepDefination"}
,plugin = {"pretty","html:target/report/cucumber"})
public class AppTest extends AbstractTestNGCucumberTests {

}
