package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser) {
        driver = new DriverManager().initialize(browser);
//        driver.get("https://askomdch.com/");
        driver.get(ConfigLoader.getInstance().getbaseURL());
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //     System.out.println(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
