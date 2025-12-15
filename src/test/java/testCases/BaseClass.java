package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;  //for login activities we need this..
	public Properties p; //loading properties  from properties file..
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException
	{ //created this switch for parallel and cross testing..
	FileReader file = new FileReader("./src//test//resources//config.properties");
	p=new Properties();	 //it will assigning properties to p.
	p.load(file); //loading files..
	logger =LogManager.getLogger(this.getClass());  //log4j2
	
	switch(br.toLowerCase()){
	case "chrome": driver= new ChromeDriver(); break;
	case "edge": driver= new EdgeDriver();break;
	case "firefox": driver= new FirefoxDriver();break;
	default: System.out.println("invalid browser name"); return;
	
	}
	
	
	//driver.get("https://tutorialsninja.com/demo/");
	//using property file..
	driver.get(p.getProperty("appURL"));
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	}
	@AfterClass
	public void tearUp() 
	{
		driver.quit();
		
	}
	
	//but this is registartion page so if we do hard code means if we 
	
	public String randomString() 
	{
	    String genaratedString= RandomStringUtils.randomAlphabetic(5);
	    return genaratedString;
    }
	
	//if we have mobile number field..
   public String numberString() 
	{
	    String genaratednumber= RandomStringUtils.randomNumeric(10);
	    return genaratednumber;
    }
    
   //alphanumeric  means for password fields..
    // if we have confirmed password we have to enter same right so we can store alphanumebric avlue into a string and pass hat stinf into brackets..
    public String alphaNumberString() 
	{
	    String genaratednumber= RandomStringUtils.randomNumeric(3);
	    String genaratedString= RandomStringUtils.randomAlphabetic(5);
	    return (genaratedString +"#"+ genaratednumber);
	   
    }
	

}
