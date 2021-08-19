package org.selenium.pom.tests;

import org.selenium.pom.base.BasePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.annotations.Test;

public class Navigationtest extends BaseTest {

    @Test
    public void navigationFromHomeToStoreUsingMainMenu(){
     HomePage homePage=new HomePage(driver);
        homePage.load();
        StorePage storePage= homePage.clickStoreMenuLink();
    }
}
