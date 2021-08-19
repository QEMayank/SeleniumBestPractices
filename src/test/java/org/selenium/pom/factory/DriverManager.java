package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;

    public WebDriver initialize(String browser){

        String browserName=System.getProperty("browser","chrome");
        switch(browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver=new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().cachePath("Drivers").setup();
                driver=new EdgeDriver();
                break;
        }





        return driver;


    }
}
