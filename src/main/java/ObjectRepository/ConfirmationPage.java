package ObjectRepository;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.genericLibrary.BaseClass;
import com.google.common.io.Files;

public class ConfirmationPage extends BaseClass {

	@FindBy(xpath = "//h2[.='Thank you for your order!']")
	private WebElement cmssg;
	
	@FindBy(xpath = "//span[.='Checkout: Complete!']")
	private WebElement Orderstatus;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCmssg() {
		return cmssg;
	}

	public WebElement getOrderstatus() {
		return Orderstatus;
	}
	
	public void ConfirmationMssg() throws IOException {
		String mssg = getCmssg().getText();
		Reporter.log(mssg,true);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot./ss.png");
	    Files.copy(src,dest);
	}
	
	

}
