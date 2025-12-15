package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//pom file for account register..page
public class AccountRegisterpage extends basepage
{
	//constructor
	public AccountRegisterpage(WebDriver driver) {
		super(driver);
	}
	
	
	//locators..
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailbox;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtMobileno;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtcfrmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement tglPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;
	
	//acton methods
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmailbox.sendKeys(email);
	}
	public void setContactno(String mobileno)
	{
		txtMobileno.sendKeys(mobileno);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void setCfrmPassword(String pwd)
	{
		txtcfrmpassword.sendKeys(pwd);
	}
	
	public void setPrivacypolicy()
	{
		tglPrivacyPolicy.click();
	}
	
	public void setcontinue()
	{
		btncontinue.click();
	}
	
	public String confirmmessage() {  //return type is string..
		try {
			return (confirmMsg.getText()); //if sucess getting success message..that one also returning..
			}
		catch(Exception e){ 
			
			return(e.getMessage()); //if getting error taht onw also returning
		}
	}
}

