package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import pages.CheckOutPage;

import java.util.List;


public class SeleniumTests extends BaseTests {
    @DataProvider(name = "dataSets")
    public Object[][] provideData() {

        return new Object[][] {
                { "Sauce Labs Bike Light", "Test","Test","057" }
        };
    }


    @Test(dataProvider = "dataSets")

    public void PlaceOrder(String ItemName,String FirstName,String LastName,String PostalCode) throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckOutPage checkOut = new CheckOutPage(driver);
        login.login();
        Reporter.log("login successful");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");
        home.addItemToCart(ItemName);
        cart.reviewCart();
        Reporter.log("Items have been added successfully");
        List<String> itemsInCart=cart.getItemsInCart();
        Assert.assertTrue(itemsInCart.contains(ItemName));
        cart.checkOutCart();
        checkOut.continueCheckout(FirstName,LastName,PostalCode);
        String message=checkOut.finishOrder();
        Assert.assertTrue(message.contains("Thank you for your order!"));
        Reporter.log("Order placed successfully");
    }
}