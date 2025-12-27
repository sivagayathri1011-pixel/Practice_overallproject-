/*package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends basepage{

    public SearchPage(WebDriver driver) {
    	super(driver);
    }

    By products = By.xpath("//div[contains(@class,'product-thumb')]");
    By quantity = By.xpath("//input[@id='input-quantity']");
    By addToCartBtn = By.xpath("//button[@id='button-cart']");
    By successMsg = By.xpath("//div[contains(@class,'alert-success')]");

    public boolean isProductExist(String pname) {
        List<WebElement> list = driver.findElements(products);
        for (WebElement p : list) {
            if (p.getText().contains(pname)) return true;
        }
        return false;
    }

    public void selectProduct(String pname) {
        driver.findElement(By.linkText(pname)).click();
    }

    public void setQuantity(String qty) {
        WebElement q = driver.findElement(quantity);
        q.clear();
        q.sendKeys(qty);
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

  //  public boolean checkConfMsg() {
    //    return driver.findElement(successMsg).isDisplayed();
    //}
    
    
    public boolean checkConfMsg() {
        try {
            return driver.findElement(successMsg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement price = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(),'Total')]/following-sibling::td"))
        );
        return price.getText();
    }

} */

package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends basepage {

    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[contains(@class,'product-thumb')]")
    List<WebElement> products;

    @FindBy(id = "input-quantity")
    WebElement quantity;

    @FindBy(id = "button-cart")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMsg;

    public boolean isProductExist(String pname) {
        for (WebElement p : products) {
            if (p.getText().contains(pname)) {
                return true;
            }
        }
        return false;
    }

    public void selectProduct(String pname) {
        for (WebElement p : products) {
            if (p.getText().contains(pname)) {
                p.findElement(By.tagName("a")).click();
                break;
            }
        }
    }

    public void setQuantity(String qty) {
        wait.until(ExpectedConditions.visibilityOf(quantity));
        quantity.clear();
        quantity.sendKeys(qty);
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public boolean checkConfMsg() {
        return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
    }
}


