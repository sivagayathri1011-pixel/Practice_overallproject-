package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterpage;
import pageObjects.Home_page;

//here @test and all comes..and validation..
public class TC001_AccountRegistration_test extends BaseClass
{
	
	
	@Test
	public void Verify_account_Registration() 
	{
		logger.info("**** starting TC001_AccountRegistration_test****** ");
		
	//first we have to create object for pom class..
		try {
		Home_page hp= new Home_page(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
	//create pom of another class account registration class..
		
		AccountRegisterpage actpage = new AccountRegisterpage(driver);
		
	/*	actpage.setFirstname("gayathri");
		actpage.setLastname("madineti");
		actpage.setEmail("siva123@gmail.com");
		actpage.setPassword("hi@1234f");
		actpage.setPrivacypolicy();
		actpage.setcontinue();
		*/
		logger.info("**** entering data into the fields****** ");
		actpage.setFirstname(randomString() );
		actpage.setLastname(randomString() );
		actpage.setEmail(randomString() +"@gmail.com");
		actpage.setContactno(numberString());
		
		//String password = randomString(); //want only string kind password
		String password =alphaNumberString(); //if want alpha numneric value
		actpage.setPassword(password ); //password and confirm password should be same so saving this in a variable and using here..
		actpage.setCfrmPassword(password);
		actpage.setPrivacypolicy();
		actpage.setcontinue();
		
		
		logger.info("**** validating confirm message****** ");
		//now validation for confirmed message
		String conmsg = actpage.confirmmessage();
		if(conmsg.equals("Your Account Has Been Created!")) 
		{
			Assert.assertTrue(true);  //here we are excepting true..if match it is true..
		}
		else {
			Assert.assertTrue(false);  //if doesnot match it is false and logs should genarate..
			logger.error("test failed and logs genarated"); //this is for genarating logs..but this codes sometimes failed so adding if condition this enetire code down..
			logger.debug("debug are genarated...");
		}
		//Assert.assertEquals(conmsg,"Your Account Has Been Created!");
	}
	catch(Exception e) {
		
		Assert.fail(); //any exception is comes this one is executed..and if not comes else block will execute
		
	}}
	//code into base class
 //what if this code return error so adding try catch method and also mentioning logs also in that..
}
