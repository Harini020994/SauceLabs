package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for login button
    By items = By.className("inventory_item");
  By addToCart=By.id("add-to-cart");

    public void selectItem(String ItemName){
        List<WebElement> availableItems=driver.findElements(items);

        for(int i=0;i<availableItems.size();i++){

            String item= availableItems.get(i).getText();
            if(item.contains(ItemName)){
                driver.findElement(By.xpath("//div[contains(text(),'"+ItemName+"')]")).click();
           break;
            }
        }

    }
    public void addItemToCart(String ItemName){
     selectItem(ItemName);
     driver.findElement(addToCart).click();

    }
}