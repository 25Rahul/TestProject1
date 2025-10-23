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
import com.genericLibrary.FileUtlis;

public class CartValidation extends BaseClass {
	
	
	public CartValidation (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'inventory_item_name']")
	private List<WebElement> prods;

	
	public List<WebElement> getProd1() {
		return prods;
	}

	//business logic
	public void cartValidation() throws IOException {
		
		FileUtlis f = new FileUtlis();
		int expectedProds = f.readNumericDataFromExcel("sourceData", 1, 5);
		Assert.assertEquals(prods.size(), expectedProds,"Cart Contains more than or less than 2 products.");
		Reporter.log("Cart Validation Sucessfull",true);
		
	  
	}
	
	public ArrayList<String> prodList() {
		ArrayList<String> CartProds = new ArrayList<String>();
		for(WebElement wb :prods){
			CartProds.add(wb.getText());
		}
		
		return CartProds;
	
		
	}
 
}
