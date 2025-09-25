package object_repository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriverutility.WebdriverUtility;

public class Flipkartsearch {
	
	WebDriver driver;
	
	WebdriverUtility wlib = new WebdriverUtility();

	 public Flipkartsearch(WebDriver driver) {
		 this.driver = driver;

	        PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//span[@role='button']")
	 private WebElement closenotification;

	public WebElement getClosenotification() {
		return closenotification;
	}

	@FindBy(name="q")
	private WebElement searchtxtfield;

	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}

	public void searchproduct(String Product) {

//		wlib.waitForElementPresentToLoad(driver, searchtxtfield);
		searchtxtfield.click();
		searchtxtfield.sendKeys(Product,Keys.ENTER);
		
//		Actions action = new Actions(driver);
//		action.moveToElement(searchtxtfield).perform();
//		
//		action.sendKeys(Product).perform();
//			
	}

}
