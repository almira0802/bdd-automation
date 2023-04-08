package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import library.ConfigReader;
import library.PropertiesReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", glue = "stepDefinitions", tags="@Smoke")

public class TestRunnerSmoke extends AbstractTestNGCucumberTests {

	PropertiesReader pro;
	
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	@BeforeTest
	public void getBrowser() {
		pro = new PropertiesReader();
		String browser = pro.getData("browser");
		ConfigReader.setBrowserType(browser);
	}
}
