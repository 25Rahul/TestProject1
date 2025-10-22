package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "user-name")
	private WebElement untbx;
	
	@FindBy(id = "password")
	private WebElement pwtbx;
	
	@FindBy(id = "login-button")
	private WebElement lgbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	//business logic
	
	public void login(WebDriver driver , String Username, String Password ) {
		LoginPage lp = new LoginPage(driver);
		lp.getUntbx().sendKeys(Username);
		lp.getPwtbx().sendKeys(Password);
		lp.getLgbtn().click();
	}

}
