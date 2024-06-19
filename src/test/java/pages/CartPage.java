package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for login button
    By cart = By.id("shopping_cart_container");
By checkout=By.id("checkout");
By cartItems=By.xpath("//div[@class='cart_list']//div[@class='cart_item']//div[@class='cart_item_label']/a");
    public void reviewCart() {
        driver.findElement(cart).click();
    }

    public List<String> getItemsInCart() {
        List<String> Itemsincart = new ArrayList<String>();
        List<WebElement> ItemsincartElement=driver.findElements(cartItems);
        for(WebElement element: ItemsincartElement )
            Itemsincart.add(element.getText());
        return Itemsincart;

    }
    public void checkOutCart() {
        driver.findElement(checkout).click();

    }
}