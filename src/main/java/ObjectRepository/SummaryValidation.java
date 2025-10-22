package ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.genericLibrary.BaseClass;
import com.genericLibrary.FileUtlis;

public class SummaryValidation extends BaseClass {
	

	@FindBy(id = "finish")
	private WebElement finishbtn;


	public WebElement getFinishbtn() {
		return finishbtn;
	}

	public SummaryValidation (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void checkOrderSummary(WebDriver driver) throws IOException {
		FileUtlis f = new FileUtlis();
		 int acutalItems = f.readNumericDataFromExcel("sourcedata", 1, 5);
		 List<WebElement> numberOfaddedItom = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			int count1=numberOfaddedItom.size();
			if(count1==acutalItems) {
				Reporter.log("Order Summary-Validation-Successfull",true);
			}
			else {
				Reporter.log("Order Summary-Validation-Failed",true);
			}
			
			getFinishbtn().click();
			
	}

}
