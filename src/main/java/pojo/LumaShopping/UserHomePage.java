package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHomePage extends Base {

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement title;

    @FindBy(xpath = "//a[normalize-space()='Bill Pay']")
    private WebElement billPay;

    @FindBy(xpath = "//div[@id='rightPanel']/p")
    private WebElement message;


    public UserHomePage(WebDriver driver){
        super(driver);
    }

    public boolean isRegistrationSuccessful(){
        return  message.getText().contains("Your account was created successfully. You are now logged in.");
    }

    public BillPaymentPage billPay(){
        billPay.click();
        return new BillPaymentPage(driver);

    }
}
