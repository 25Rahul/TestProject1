package ObjectRepository;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage  {

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement prod1;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement prod2;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cartbtn;
	
	@FindBy(id = "continue")
	private WebElement continuebtn;
	

	
	public WebElement getProd1() {
		return prod1;
	}

	public WebElement getProd2() {
		return prod2;
	}

	public WebElement getCartbtn() {
		return cartbtn;
	}
	
	public WebElement getContinuebtn() {
		return continuebtn;
	}
	
	
	public void AddtoCart(WebDriver driver) throws InterruptedException, IOException {
		
		getProd1().click();
		Thread.sleep(1000);
		getProd2().click();
		Thread.sleep(1000);
		getCartbtn().click();
		
		CartValidation cv = new CartValidation(driver);
		cv.cartValidation();
		
		
	}
	
	

	

}
