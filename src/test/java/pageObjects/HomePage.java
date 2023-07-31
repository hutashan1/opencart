package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage

{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	// finding locators
	@FindBy(linkText="Register") WebElement lnkRegister;
	@FindBy(linkText="Login") WebElement lnkLogin;
	
	//Action related to locatores
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
}

	
	
	


