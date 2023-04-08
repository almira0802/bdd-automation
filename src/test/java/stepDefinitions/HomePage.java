package stepDefinitions;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.BaseTest;
import library.ConfigReader;
import pageObjects.HomePageObject;

public class HomePage extends BaseTest {

	HomePageObject homePage;

	@Given("^The user lauches the application$")
	public void the_user_lauches_the_application() {
		String browser = ConfigReader.getBrowserType();
		homePage = new HomePageObject(lauchApplication(browser));
	}

	@When("^The user searches an item \"([^\"]*)\"$")
	public void the_user_searches_an_item(String items) {
		homePage.search.sendKeys(items);
		homePage.search.sendKeys(Keys.ENTER);
		Reporter.log("The item is searched successfully!!");

	}

	@Then("^The user closes the browser$")
	public void the_user_closes_the_browser() {
		closeBrowser();
	}

}
