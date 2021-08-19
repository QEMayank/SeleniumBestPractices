package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.StorePage;
import org.testng.annotations.Test;

public class AddToCarttest extends BaseTest {

    @Test
    public void addProductToCart(){
        CartPage cartPage =new StorePage(driver)
        .load()
        .addToCartBtn("Blue Shoes")
        .clickViewCartBtn();
    }
}
