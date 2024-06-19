package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for login button
    By firstName = By.id("first-name");
    By lastName=By.id("last-name");
    By postalCode=By.id("postal-code");
    By continueBtn=By.id("continue");
    By cartItems=By.xpath("//div[@class='cart_list']//div[@class='cart_item']//div[@class='cart_item_label']/a");
By finish=By.id("finish");
By message=By.className("complete-header");
    public void fillInformation(String frstName,String Lstname,String postCode) {
        driver.findElement(firstName).sendKeys(frstName);
        driver.findElement(lastName).sendKeys(Lstname);
        driver.findElement(postalCode).sendKeys(postCode);

    }
    public void continueCheckout(String frstName,String Lstname,String postCode) {
        fillInformation(frstName,Lstname,postCode);
        driver.findElement(continueBtn).click();

    }
    public void cancelCheckout(String frstName,String Lstname,String postCode) {
        fillInformation(frstName,Lstname,postCode);
        driver.findElement(continueBtn).click();

    }
public List<String> reviewOrder(List<String> items){
    List<String> Itemsincart = new ArrayList<String>();
    List<WebElement> ItemsincartElement=driver.findElements(cartItems);
    for(WebElement element: ItemsincartElement )
        Itemsincart.add(element.getText());
    return Itemsincart;
}
public String finishOrder(){
        driver.findElement(finish).click();
    return driver.findElement(message).getText();
}
}