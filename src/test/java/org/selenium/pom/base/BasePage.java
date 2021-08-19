package org.selenium.pom.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.Objects.BillingAddress;
import org.selenium.pom.utils.ConfigLoader;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    }

public void load(String ...path){
    System.out.println(ConfigLoader.getInstance().getbaseURL()+path[0]);
        driver.get(ConfigLoader.getInstance().getbaseURL()+path[0]);
}






    public void waitForOverLay(By overLay){
        List<WebElement> overLayElements= driver.findElements(overLay);
        System.out.println("OverLay size is" + overLayElements.size());
        if(overLayElements.size()>0){
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(overLay)));
            System.out.println("Overlay is not visible");
        }
        else{
            System.out.println("Overlay not found");

        }

    }
}
