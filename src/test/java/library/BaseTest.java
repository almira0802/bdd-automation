package library;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BaseTest {

	public PropertiesReader pro;
	public static WebDriver driver;

	public WebDriver lauchApplication(String browser) {
		pro = new PropertiesReader();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.drive", "src/test/resources/geckodriver");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resoures/IEDriverServer");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(pro.getData("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("The application is launched successfully!!");
		return driver;
	}

	public void closeBrowser() {
		driver.quit();

	}

}
