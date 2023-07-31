package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPagae;
import pageObjects.MyAccount;

public class TC_002_Login extends BaseClass
{
  @Test
  public void login() throws InterruptedException 
  {
	  HomePage hp=new HomePage(driver);
	  LoginPagae lp=new LoginPagae(driver);
	  MyAccount ma=new MyAccount(driver);
	  
	  hp.clickLogin();
	 Thread.sleep(1000000);
	  lp.setEmail(rb.getString("email"));
	  lp.setPass(rb.getString("password"));
	  
	  boolean status=ma.isDisplayed();
	  try
	  {
	  Assert.assertEquals(status, true);
	  }
	  catch(Exception e)
	  {
		  Assert.fail();
	  }
  }
}
