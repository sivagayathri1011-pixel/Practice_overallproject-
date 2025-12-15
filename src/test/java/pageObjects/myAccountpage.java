package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//pom for myaccount page
public class myAccountpage extends basepage
{

	public myAccountpage(WebDriver driver) 
	{
		super(driver);
		
	}
  //after login we need to validate login message..
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement cfrmmsg;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	//action method for my account...
	
	public boolean isMyAccountPageExists()
	{
	try {
	 return(cfrmmsg.isDisplayed());  //if exists just return confirm message if not return false..
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	
	public void clickLogout() {
		btnLogout.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
