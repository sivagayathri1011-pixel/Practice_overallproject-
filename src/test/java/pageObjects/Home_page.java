package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//pom class for homepage
/*in pom class we have to create 1) constructor
 *                                2)locators
 *                                3) action methods
 *  and here we want to choose and registration we have to click..
 */
public class Home_page extends  basepage
{
//	WebDriver driver; this also dont need we can invoke basepage driver here...
  /*  Home_page (WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);}*/
	//we will use this part as we ahve pom files we can create this ok..so reduce duplaction creating one class for this constructor 
	//i.e base class ..after creating we have to extend base class(parent) to homepage class (child)
	//and after this using inheritance invoking the constructor using super key.. 
	
	
	public Home_page(WebDriver driver)
	{
		super(driver);
	}
	
	//create locators
	/*we want to registration first we have to find myaccount
	 * next is register button..
	 */
	
	

	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement linkRegistration;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linklogin; //for login
	
	// -------- SEARCH LOCATORS --------
	@FindBy(xpath = "//input[@name='search']")
	WebElement txtSearch;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;

	// -------- SEARCH ACTION METHODS --------
	public void enterProductName(String productName) {
	    txtSearch.clear();
	    txtSearch.sendKeys(productName);
	}

	public void clickSearch() {
	    btnSearch.click();
	}

	
	//action methods
	
	public void clickMyAccount() 
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister() 
	{
		linkRegistration.click();
	}
	
	public void btnlogin()
	{
		linklogin.click();
	}

}
