package baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_fileutility.FileUtility;
import webdriverutility.WebdriverUtility;

public class BaseClass {

	FileUtility flib = new FileUtility();
	WebdriverUtility wlib = new WebdriverUtility();

	public WebDriver driver;

	@BeforeClass
	public void beforeclassConfig() throws Throwable {

		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.toMaximize(driver);
		wlib.waitForPageLoad(driver);
		String URL = flib.getDataFromPropertiesFile("url");

		driver.get(URL);
	}
	
	@BeforeMethod
	public void beforeCongig() {
		
	}

	@AfterClass(alwaysRun = true)
	public void afterclassConfig() {
	 driver.quit();
		System.out.println("driver quit");
		
	}

}
