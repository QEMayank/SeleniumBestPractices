package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {


    private final By storeLink =By.cssSelector("#menu-item-1227");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public StorePage clickStoreMenuLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(storeLink)).click();
//        driver.findElement(storeLink).click();
        return new StorePage(driver);

    }

//    public void launchURL(){
//        load();
//
//    }
}
