package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    private final By checkoutBtn =By.cssSelector(".checkout-button.button.alt.wc-forward");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickCheckBTn(){
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);

    }
}
