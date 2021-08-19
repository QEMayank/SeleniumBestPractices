package org.selenium.pom.tests;

import org.selenium.pom.Objects.BillingAddress;
import org.selenium.pom.Objects.User;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private BillingAddress billingAddress;

    @Test
    public void driverTestcase() throws InterruptedException, IOException {

      //  billingAddress=new BillingAddress("Demo2","User2","SanFranCisco","San Francisco","09090","askmayank@naman.com");

   BillingAddress billingAddress=new BillingAddress();

//   String filePath="C:\\diskE\\FrameworkBestPractices\\RetailAutomation\\src\\test\\java\\org\\selenium\\pom\\resources";

   billingAddress=JacksonUtils.deserializeJson("myBilling.json",BillingAddress.class);
//        BillingAddress billingAddress=new BillingAddress();
//        billingAddress.setFirstName("Demo2");
//        billingAddress.setLastName("User2");
//        billingAddress.setBillingAddressOne("SanFrancisco");
//        billingAddress.setBillingAddressCity("San Francisco");
//        billingAddress.setBillingAddressPostalCode("09090");
//        billingAddress.setBillingAddressEmail("askmayank@naman.com");
        homePage=new HomePage(driver);
    //    homePage.load();
       StorePage storePage= homePage.clickStoreMenuLink();
       storePage.enterValueInSearchField("Blue");
       storePage.clickSubmitButton();
       storePage.addToCartBtn("Blue Shoes");
  //     Thread.sleep(3000);
       cartPage=storePage.clickViewCartBtn();
      checkoutPage= cartPage.clickCheckBTn();
      checkoutPage.
//              enterBillingFirstName("demo").
//              enterBillingLastName("User").
//              enterBillingAddress1("San FranCisco").
//              enterBillingCity("Wales").
//              enterBillingPostcode("09090").
//              enterBillingEmail("demo@mayank.com").
//              clickPlaceOrder();
        setBillingInfo(billingAddress).clickPlaceOrder();
//        Thread.sleep((7000));
        Assert.assertEquals(checkoutPage.getOderConfirmation(),"Thank you. Your order has been received.");


    }

    @Test
    public void secondTestCases() throws IOException {
        //  billingAddress=new BillingAddress("Demo2","User2","SanFranCisco","San Francisco","09090","askmayank@naman.com");

        BillingAddress billingAddress=new BillingAddress();
        billingAddress=JacksonUtils.deserializeJson("myBilling.json",BillingAddress.class);
        User user=new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());

//        BillingAddress billingAddress=new BillingAddress();
//        billingAddress.setFirstName("Demo2");
//        billingAddress.setLastName("User2");
//        billingAddress.setBillingAddressOne("SanFrancisco");
//        billingAddress.setBillingAddressCity("San Francisco");
//        billingAddress.setBillingAddressPostalCode("09090");
//        billingAddress.setBillingAddressEmail("askmayank@naman.com");
        homePage=new HomePage(driver);
      //  homePage.load();
        StorePage storePage= homePage.clickStoreMenuLink();
        storePage.enterValueInSearchField("Blue");
        storePage.clickSubmitButton();
        storePage.addToCartBtn("Blue Shoes");
        //     Thread.sleep(3000);
        cartPage=storePage.clickViewCartBtn();
        checkoutPage= cartPage.clickCheckBTn().
                showLogin().
                Login(user.getUsername(), user.getPassword());
        checkoutPage.
//              enterBillingFirstName("demo").
//              enterBillingLastName("User").
//              enterBillingAddress1("San FranCisco").
//              enterBillingCity("Wales").
//              enterBillingPostcode("09090").
//              enterBillingEmail("demo@mayank.com").
//              clickPlaceOrder();
        setBillingInfo(billingAddress).clickPlaceOrder();
//        Thread.sleep((7000));
        Assert.assertEquals(checkoutPage.getOderConfirmation(),"Thank you. Your order has been received.");


    }
    }

