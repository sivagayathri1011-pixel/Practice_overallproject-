/*package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends basepage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // ---------- XPATH LOCATORS ----------
    By cart = By.xpath("//span[@id='cart-total']");
    By viewCart = By.xpath("//strong[normalize-space()='View Cart']");
    By totalPrice = By.xpath("//table[contains(@class,'table-bordered')]//td[@class='text-right'][last()]");
    By checkout = By.xpath("//strong[normalize-space()='Checkout']");

    // ---------- METHODS ----------
    public void clickItemsToNavigateToCart() {
        driver.findElement(cart).click();
    }

    public void clickViewCart() {
        driver.findElement(viewCart).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkout).click();
    }
} */

package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends basepage {

    WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "cart-total")
    WebElement cart;

    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    WebElement viewCart;

    @FindBy(xpath = "//table[contains(@class,'table-bordered')]//td[@class='text-right'][last()]")
    WebElement totalPrice;

    @FindBy(xpath = "//strong[normalize-space()='Checkout']")
    WebElement checkout;
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    WebElement stockErrorMsg;

    public void clickItemsToNavigateToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }

    public String getTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }
    public boolean isStockErrorDisplayed() {
        try {
            return stockErrorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
