package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Searchtest extends BaseTest {

    @Test
    public void searchUsingPartialMatch(){

        StorePage storePage=new StorePage(driver).load();
        storePage.enterValueInSearchField("Blue");
        storePage.clickSubmitButton();


        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");


    }
}
