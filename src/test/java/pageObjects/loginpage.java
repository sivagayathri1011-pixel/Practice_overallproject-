package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//pom for login page..
public class loginpage extends basepage
{

	public loginpage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	//locators..
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	//action methods..
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
}
