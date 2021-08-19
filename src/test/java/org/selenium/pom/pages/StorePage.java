package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchField=By.cssSelector("#woocommerce-product-search-field-0");
    private final By clickSubmitBtn=By.cssSelector(" button[value='Search']");
    private final By addToCartBtn=By.cssSelector("[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartBtn=By.cssSelector(".added_to_cart.wc-forward");
    private final By getTitle=By.cssSelector(".woocommerce-products-header__title.page-title");


    public StorePage(WebDriver driver){
        super(driver);

    }

    public void enterValueInSearchField(String text){
        driver.findElement(searchField).sendKeys(text);


    }

    public void clickSubmitButton(){
        driver.findElement(clickSubmitBtn).click();
    }


    /**
     * This method will help us to dynamically create an elements
     * @param product
     * @return
     */

    public By getProductCartElement(String product){
        return By.cssSelector("[aria-label='Add “" + product + "” to your cart']");
    }

    public StorePage addToCartBtn(String product){
        By element=getProductCartElement(product);
        driver.findElement(element).click();
        return  this;
    }
    public CartPage clickViewCartBtn(){
        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }
    public StorePage load(){
        load("store");
        return this;

    }

    public String getTitle(){
        wait.until(ExpectedConditions.urlContains("post_type"));
        return driver.findElement(getTitle).getText();

    }




}
