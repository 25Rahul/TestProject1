package TestScripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.genericLibrary.BaseClass;
import com.genericLibrary.FileUtlis;

import ObjectRepository.CheckOutPage;
import ObjectRepository.HomePage;
import ObjectRepository.SummaryValidation;


public class Demo extends BaseClass{
	@Test
	public void VerifyHomePage() throws InterruptedException, IOException {
		
		List<WebElement> allprods = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		int count = allprods.size();
		int n = 6;
		if(n==count) {
			Reporter.log("Login Page Verification Sucessfull",true);
		}
		else {
			Reporter.log("Login Page Verification Unsucessfull",true);
		}
		
		
		 HomePage hp = new HomePage(driver);
		 hp.AddtoCart(driver);
		 
		 
		 FileUtlis f = new FileUtlis();
		 String fn=f.readDataFromExcel("sourcedata", 1, 7);
		 String ln=f.readDataFromExcel("sourcedata", 1, 8);
		 int zip=(int) f.readNumericDataFromExcel("sourcedata", 1, 9);
		 CheckOutPage cp = new CheckOutPage(driver);
		 cp.CheckOut(fn, ln, zip);
		
		 SummaryValidation sv =new SummaryValidation(driver);
		 sv.checkOrderSummary(driver);
		 
		 String ConfirmationMssg = driver.findElement(By.xpath("//h2[.='Thank you for your order!']")).getText();
		 Reporter.log(ConfirmationMssg,true);
		 Thread.sleep(2000);

	} 
}

