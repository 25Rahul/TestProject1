package ObjectRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import com.genericLibrary.BaseClass;


public class SummaryValidation extends BaseClass {
	
	@FindBy(xpath = "//div[@class = 'inventory_item_name']")
	private List<WebElement> prods;

	
	public List<WebElement> getProd1() {
		return prods;
	}

	@FindBy(id = "finish")
	private WebElement finishbtn;


	public WebElement getFinishbtn() {
		return finishbtn;
	}

	public SummaryValidation (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//business logic
	public void checkOrderSummary(WebDriver driver) throws IOException {
		ArrayList<String> OrderSummProds = new ArrayList<String>();
		for(WebElement wb :prods) {
			OrderSummProds.add(wb.getText());
		}
		CartValidation cv = new CartValidation(driver);
		Assert.assertEquals(cv.prodList(), OrderSummProds,"Order Summary Validation Failed");
		Reporter.log("Order Summary Validation Sucessfull",true);
		getFinishbtn().click();
			
	}

}
