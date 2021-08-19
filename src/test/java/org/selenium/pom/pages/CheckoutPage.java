package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.Objects.BillingAddress;
import org.selenium.pom.base.BasePage;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {

    private final By billingFirstName=By.cssSelector("#billing_first_name");
    private final By billingLastName=By.cssSelector("#billing_last_name");
    private final By billingAddress1=By.cssSelector("#billing_address_1");
    private final By billingCity=By.cssSelector("#billing_city");
    private final By billingPostcode=By.cssSelector("#billing_postcode");
    private final By billingEmail=By.cssSelector("#billing_email");
    private final By placeOrder=By.cssSelector("#place_order");
    private final By orderConfirmationTxt=By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
    private final By overlayComponent=By.cssSelector(".blockUI.blockOverlay");
    private final By countryDropDown=By.cssSelector("#billing_country");
    private final By stateDropDown=By.cssSelector("#billing_state");
    private final By showLogin=By.cssSelector(".showlogin");
    private final By usernameTxt=By.cssSelector("#username");
    private final By passwordTxt=By.cssSelector("#password");
    private final By btnLogin=By.cssSelector("[name='login']");






    public CheckoutPage(WebDriver driver) {
        super(driver);


    }

    public CheckoutPage enterBillingFirstName(String text){
        driver.findElement(billingFirstName).sendKeys(text);
        return this;
    }

    public CheckoutPage enterBillingLastName(String text){
        driver.findElement(billingLastName).sendKeys(text);
        return this;
    }

    public CheckoutPage enterBillingAddressOne(String text){
        driver.findElement(billingAddress1).sendKeys(text);
        return this;
    }

    public CheckoutPage enterBillingCity(String text){
        driver.findElement(billingCity).sendKeys(text);
        return this;
    }

    public CheckoutPage enterBillingPostcode(String text){
        driver.findElement(billingPostcode).sendKeys(text);
        return this;
    }

    public CheckoutPage enterBillingEmail(String text){
        driver.findElement(billingEmail).clear();
        driver.findElement(billingEmail).sendKeys(text);
        return this;
    }


    public CheckoutPage clickPlaceOrder(){

        List<WebElement> overLay=driver.findElements(overlayComponent);
        waitForOverLay(overlayComponent);
        driver.findElement(placeOrder).click();
        return this;
    }

    public void selectCountryName(String Country){
        Select select =new Select(driver.findElement(countryDropDown));
        select.selectByValue(Country);
    }

    public void selectStateName(String State){
        Select select =new Select(driver.findElement(stateDropDown));
        select.selectByValue(State);
    }


    public CheckoutPage setBillingInfo(BillingAddress billingAddress){


        enterBillingFirstName(billingAddress.getFirstName());
        enterBillingLastName(billingAddress.getLastName());
        enterBillingAddressOne(billingAddress.getBillingAddressOne());
        enterBillingCity(billingAddress.getBillingAddressCity());
        enterBillingPostcode(billingAddress.getBillingAddressPostalCode());
        enterBillingEmail(billingAddress.getBillingAddressEmail());

        return this;

    }

    public CheckoutPage showLogin(){
        driver.findElement(showLogin).click();
        return this;

    }

    public CheckoutPage Login(String username,String password){
        driver.findElement(usernameTxt).sendKeys(username);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(btnLogin).click();
        return this;
    }




    public String getOderConfirmation(){
        return driver.findElement(orderConfirmationTxt).getText().trim();

    }




}
