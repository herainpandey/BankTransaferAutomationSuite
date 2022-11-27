package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParabankHomePage extends Base {


    @FindBy(xpath ="//input[@name='username']")
    private WebElement userInput;

    @FindBy(xpath ="//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath ="//input[@value='Log In']")
    private WebElement loginBtn;

    @FindBy(xpath ="//a[normalize-space()='Forgot login info?']")
    private WebElement forgotLoginInfoLink;

    @FindBy(xpath ="//a[contains(.,'Register')]")
    private WebElement registerLink;

    public ParabankHomePage(WebDriver driver){
     super(driver);
    }

    public void setUserName(String user){
        userInput.sendKeys(user);
    }

    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public WebElement loginBtn(){
        return loginBtn;
    }

    public UserRegistrationPage clickRegisterLink(){
         registerLink.click();
         return new UserRegistrationPage(driver);
    }

    public WebElement forgotLoginInfoLink(){
        return forgotLoginInfoLink;
    }


}
