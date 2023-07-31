package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagae extends BasePage
{

	public LoginPagae(WebDriver driver)
	{
		super(driver);
		
	}
	//locators
	@FindBy(id="input-email")WebElement txt_email;
	
	@FindBy(id="input-password")WebElement txt_pass;
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg hidden-xs']")WebElement btn_submit;
	
	//actions 
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setPass(String pass)
	{
		txt_pass.sendKeys(pass);
	}
	public void clickSubmit()
	{
		btn_submit.click();
	}

}
