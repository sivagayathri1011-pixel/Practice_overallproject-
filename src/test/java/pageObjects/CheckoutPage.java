package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends basepage {

    

    // -------- CONSTRUCTOR --------
    public CheckoutPage(WebDriver driver) {
    	super(driver);
    }

    // -------- XPATH LOCATORS --------
    By firstName   = By.xpath("//input[@id='input-payment-firstname']");
    By lastName    = By.xpath("//input[@id='input-payment-lastname']");
    By address1   = By.xpath("//input[@id='input-payment-address-1']");
    By address2   = By.xpath("//input[@id='input-payment-address-2']");
    By city       = By.xpath("//input[@id='input-payment-city']");
    By postcode   = By.xpath("//input[@id='input-payment-postcode']");
    By country    = By.xpath("//select[@id='input-payment-country']");
    By state      = By.xpath("//select[@id='input-payment-zone']");

    By continueBillingBtn        = By.xpath("//input[@id='button-payment-address']");
    By continueDeliveryAddressBtn= By.xpath("//input[@id='button-shipping-address']");
    By deliveryComment           = By.xpath("//textarea[@name='comment']");
    By continueDeliveryMethodBtn = By.xpath("//input[@id='button-shipping-method']");
    By termsCheckbox             = By.xpath("//input[@name='agree']");
    By continuePaymentMethodBtn  = By.xpath("//input[@id='button-payment-method']");
    By totalPriceBeforeConfirmOrder = By.xpath("//table[@class='table table-bordered table-hover']//tr[last()]/td[2]");

    // -------- ACTION METHODS --------

    public void setfirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void setlastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void setaddress1(String add1) {
        driver.findElement(address1).sendKeys(add1);
    }

    public void setaddress2(String add2) {
        driver.findElement(address2).sendKeys(add2);
    }

    public void setcity(String cityName) {
        driver.findElement(city).sendKeys(cityName);
    }

    public void setpin(String pin) {
        driver.findElement(postcode).sendKeys(pin);
    }

    public void setCountry(String countryName) {
        driver.findElement(country).sendKeys(countryName);
    }

    public void setState(String stateName) {
        driver.findElement(state).sendKeys(stateName);
    }

    public void clickOnContinueAfterBillingAddress() {
        driver.findElement(continueBillingBtn).click();
    }

    public void clickOnContinueAfterDeliveryAddress() {
        driver.findElement(continueDeliveryAddressBtn).click();
    }

    public void setDeliveryMethodComment(String comment) {
        driver.findElement(deliveryComment).sendKeys(comment);
    }

    public void clickOnContinueAfterDeliveryMethod() {
        driver.findElement(continueDeliveryMethodBtn).click();
    }

    public void selectTermsAndConditions() {
        driver.findElement(termsCheckbox).click();
    }

    public void clickOnContinueAfterPaymentMethod() {
        driver.findElement(continuePaymentMethodBtn).click();
    }
    public String getTotalPriceBeforeConfirmOrder() {
        return driver.findElement(totalPriceBeforeConfirmOrder).getText();
    }

}


