package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//finding locator on registeration page
	@FindBy(name="first_name")WebElement txt_fname;
	@FindBy(name="last_name")WebElement txt_lname;
	@FindBy(id="inlineRadioMale")WebElement btn_gender;
	@FindBy(id="exampleFormControlSelect2")WebElement txt_hobbies;
	@FindBy(name="department")WebElement txt_depart;
	@FindBy(name="user_name")WebElement txt_uname;
	@FindBy(name="user_password")WebElement txt_pass;
	@FindBy(name="confirm_password")WebElement txt_confirm_pass;
	@FindBy(name="email")WebElement txt_email;
	@FindBy(name="contact_no")WebElement txt_no;
	@FindBy(xpath="//button[@type='submit']")WebElement btn_submit;
	@FindBy(id="success_message")WebElement txt_msg;
	
	//Action corresponding to locators
	public void setFname(String fname)
	{
		txt_fname.sendKeys(fname);
	}
	public void setLname(String lname)
	{
		txt_lname.sendKeys(lname);
	}
	public void setender()
	{
		btn_gender.click();
	}
	public void setHobbies(String hobby)
	{
		Select select=new Select(txt_hobbies);
		select.selectByVisibleText(hobby);
	}
	public void setDepartment(String depart)
	{
		Select select=new Select(txt_depart);
		select.selectByVisibleText(depart);
	}
	public void setUname(String uname)
	{
		txt_uname.sendKeys(uname);
	}
	public void setPassword(String pass)
	{
		txt_pass.sendKeys(pass);
	}
	public void confirmPassword(String cpass)
	{
		txt_confirm_pass.sendKeys(cpass);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setPhone(String phone)
	{
		txt_no.sendKeys(phone);
	}
	public void click()
	{
		btn_submit.click();;
	}	
	
	public String confirmation()
	{
		try
		{
			return txt_msg.getText();
		}
		catch(Exception e)
		{
			return null ;
		}
		
	}
	
	

}
