package flipkart;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseutility.BaseClass;
import generic_fileutility.ExcelUtility;
import object_repository.Flipkartsearch;
import webdriverutility.WebdriverUtility;

public class FlipkartToExcelfile extends BaseClass {

	WebdriverUtility wlib = new WebdriverUtility();

	ExcelUtility elib = new ExcelUtility();
	int i = 1;

	@Test(dataProvider = "getData" ,groups = "regression")
	public void getProductInfo(String Product, String Productname) throws Throwable {
		Flipkartsearch fs = new Flipkartsearch(driver);

		fs.searchproduct(Product);

		try {
			String data = driver
					.findElement(By.xpath("//div[.='" + Productname + "']/../..//div[contains(@class,'Nx9bqj')]"))
					.getText();
			elib.getDataToExcelFile("Products", i, 2, data);

		} catch (Exception e) {
			elib.getDataToExcelFile("Products", i, 2, "NA");
		} finally {
			i++;
			wlib.navigateback(driver);
		}
		try {

			fs.getClosenotification().click();
		} catch (Exception e) {
			System.out.println("no close popup appear");
		}

	}

	@DataProvider
	public Object[][] getData() throws Throwable {

		int rowCount = elib.getDataFromExcelFile("Products");

		Object[][] objArr = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = elib.getDatafromExcelfile("Products", i + 1, 0);
			objArr[i][1] = elib.getDatafromExcelfile("Products", i + 1, 1);

		}
		return objArr;
	}
	
	
	@Test(groups ="smoke")
	public void getproduct() {
		
		System.out.println("identified the product");
		
	}

}
