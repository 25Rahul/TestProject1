package TestScripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.genericLibrary.BaseClass;
import com.genericLibrary.FileUtlis;
import ObjectRepository.CheckOutPage;
import ObjectRepository.ConfirmationPage;
import ObjectRepository.HomePage;



public class Demo extends BaseClass{
	@Test
	public void VerifyHomePage() throws InterruptedException, IOException {
		FileUtlis f = new FileUtlis();
		
		List<WebElement> allprods = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		int count = allprods.size();
		int n =f.readNumericDataFromExcel("sourcedata", 1, 4);
		Assert.assertEquals(n, count,"Login Page Verified Failed");
		Reporter.log("Login Page Verified Sucessfully",true);
		
		HomePage hp = new HomePage(driver);
		hp.AddtoCart(driver);
		 
		String fn=f.readDataFromExcel("sourcedata", 1, 7);
		String ln=f.readDataFromExcel("sourcedata", 1, 8);
		int zip=(int) f.readNumericDataFromExcel("sourcedata", 1, 9);
		CheckOutPage cp = new CheckOutPage(driver);
		cp.CheckOut(fn, ln, zip);

		ConfirmationPage cpage = new ConfirmationPage(driver);
		cpage.ConfirmationMssg();
		Thread.sleep(2000);

	} 
}

