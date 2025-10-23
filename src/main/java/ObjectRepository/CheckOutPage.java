package ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericLibrary.BaseClass;


public class CheckOutPage  extends BaseClass{


	public CheckOutPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "checkout")
	private WebElement checkbtn;
	
	@FindBy(id = "first-name")
	private WebElement fnbx;
	
	@FindBy(id = "last-name")
	private WebElement lnbx;
	
	@FindBy(id = "postal-code")
	private WebElement zipbx;
	
	@FindBy(id = "continue")
	private WebElement contbtn;
	
	
	public WebElement getCheckoutbtn() {
		return checkbtn;
	}
	
	public WebElement getFnbx() {
		return fnbx;
	}

	public WebElement getLnbx() {
		return lnbx;
	}

	public WebElement getZipbx() {
		return zipbx;
	}
	
	
    public WebElement getContbtn() {
		return contbtn;
	}

  //business logic
	public void CheckOut(String fn,String ln,int zip) throws EncryptedDocumentException, IOException, InterruptedException {
    	
    	getCheckoutbtn().click();
    	
		Thread.sleep(1000);
		getFnbx().sendKeys(fn);
		Thread.sleep(1000);
		getLnbx().sendKeys(ln);
		Thread.sleep(1000);
		getZipbx().sendKeys(String.valueOf(zip));
		Thread.sleep(1000);
		getContbtn().click();
		SummaryValidation sv = new SummaryValidation(driver);
		sv.checkOrderSummary(driver);
	}

}
