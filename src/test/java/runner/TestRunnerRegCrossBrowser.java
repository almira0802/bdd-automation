package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import library.ConfigReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", glue = "stepDefinitions", tags = "@Regression")

public class TestRunnerRegCrossBrowser extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	// this will read browser type from the testng.xml file
	@BeforeTest
	@Parameters("browser")
	public void getBrowser(String browser) {
		ConfigReader.setBrowserType(browser);
	}

}
