package ObjectRepository;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.genericLibrary.BaseClass;
import com.genericLibrary.FileUtlis;

public class CartValidation extends BaseClass {
	
	
	public CartValidation (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'inventory_item_name']")
	private WebElement prod1;
	
	@FindBy(xpath = "//div[@class = 'inventory_item_name']")
	private WebElement prod2;
	
	public WebElement getProd1() {
		return prod1;
	}
	
	public WebElement getProd2() {
		return prod1;
	}

	public void cartValidation() throws IOException {
		FileUtlis f = new FileUtlis();
		String p1= prod1.getText();
		String p2= prod2.getText();
	    for(int i =0 ;i<=5;i++) {
	    	
			String item = f.readDataFromExcel("sourcedata",i+1,6);
	    	
	    	if(item.equals(p1) ) {
	    		Reporter.log("Verification done", true);
	    	}
	    	
	    }
	}
 
}
