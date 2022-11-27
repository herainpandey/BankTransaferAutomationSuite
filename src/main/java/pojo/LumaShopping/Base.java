package pojo.LumaShopping;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base {

    protected  WebDriver driver;

    public Base(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public boolean existsElement(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
