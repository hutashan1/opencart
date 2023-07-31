package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage
{

	public MyAccount(WebDriver driver) 
	{
		super(driver);
		
	}
	//locators
	@FindBy(linkText="Account")WebElement lnk_account;
	
	//actions
	
	public boolean isDisplayed()
	{
		boolean status=lnk_account.isDisplayed();
		return status;
	}
		

}
