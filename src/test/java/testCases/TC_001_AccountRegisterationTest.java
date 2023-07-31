	package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import testBase.BaseClass;


public class TC_001_AccountRegisterationTest extends BaseClass {
 
  @Test
  public void test() 
  {
	 logger.info("***	Starting the TC_001_AccountRegisterationTest	***");
	  AccountRegistrationPage rp=new AccountRegistrationPage(driver);
	  logger.info("***	Providing data	***");
	  rp.setFname("hutashan");
	  rp.setLname("agnihotri");
	  rp.setender();
	  rp.setHobbies("Running");
	  rp.setDepartment("MCTC");
	  rp.setUname("hutashan");
	  rp.setPassword("hutashan@1234");
	  rp.confirmPassword("hutashan@1234");
	 // rp.setPhone("9971531862");
	  logger.info("***	clicked on submit	***");
	  rp.click();
	  logger.info("***	validating the testcase	***");
	 String status= rp.confirmation();
	 System.out.println(status);
	 Assert.assertEquals(status , "Success Success!.");
  }
  

}
