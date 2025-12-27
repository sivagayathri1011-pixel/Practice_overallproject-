package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.MyAccountPage;
import pageObjects.loginpage;

public class TC002_Loginpage extends BaseClass 
{
@Test
public void loginpage() 
{
	logger.info("**** starting tc002 testcase******");
	
	Home_page hp= new Home_page(driver);
	hp.clickMyAccount();
	hp.btnlogin();
	
	loginpage lp = new loginpage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin(); //login successfully for but validation after login we have to
	//see my account page ..
	
	//validation 
	MyAccountPage map= new MyAccountPage(driver);
	Assert.assertTrue(map.isMyAccountPageExists(),"My Account page is displayed"); 
		
	








}

















}
