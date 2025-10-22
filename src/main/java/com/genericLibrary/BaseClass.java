package com.genericLibrary;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ObjectRepository.LoginPage;


public class BaseClass {
	
public WebDriver driver;
	
	@BeforeSuite  
	public void databaseConnected() {
   	 Reporter.log("Database connected successfully",true);
    }
	
	@BeforeTest
	public void LaunchBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
		driver.get("https://www.saucedemo.com/");
	    Reporter.log("Browser Launched successfully",true);
	}
	
	@BeforeMethod
	public void login() throws IOException, AWTException {
		FileUtlis f = new FileUtlis();
		String un=f.readDataFromExcel("sourcedata", 1, 1);
		String pw=f.readDataFromExcel("sourcedata", 1, 2);
		LoginPage lp = new LoginPage(driver);
		lp.login(driver, un, pw); 
	 
	}
	
	 @AfterMethod 
     public void logoutFromVtiger() throws InterruptedException, IOException {
		 
		 driver.findElement(By.id("react-burger-menu-btn")).click();
		 driver.findElement(By.id("logout_sidebar_link")).click();

     }
	
	@AfterTest
    public void closeBrowser() {
   	  driver.quit();
    }
    
    @AfterSuite
    public void databaseDisconnection() {
   	 Reporter.log("Database Disconnected",true);
    }

}
