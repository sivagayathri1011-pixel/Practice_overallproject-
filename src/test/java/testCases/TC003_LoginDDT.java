package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.MyAccountPage;
import pageObjects.loginpage;
import utilities.DataProviders;
/*  
Data is valid   – login success → test pass  → logout
                – login failed → test fail

Data is invalid – login success → test fail  → logout
                – login failed → test pass
*/


public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class)
	public void LoginDDt(String email,String password, String exp) {
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
	//Assert.assertTrue(,"My Account page is displayed"); 
	boolean targetPage = map.isMyAccountPageExists();
	
	if (exp.equalsIgnoreCase("Valid"))
	{
	    if (targetPage == true)
	    {
	    	map.clickLogout();
	        Assert.assertTrue(true);
	    }
	    else
	    {
	        Assert.assertTrue(false);
	    }
	}

	if (exp.equalsIgnoreCase("Invalid"))
	{
	    if (targetPage == true)
	    {
	    	map.clickLogout();
	        Assert.assertTrue(false);
	    }
	    else
	    {
	        Assert.assertTrue(true);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	}
}
