package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class UserRegistrationPage extends Base {


    @FindBy(xpath = "//input[@id='customer.firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    private WebElement zipcode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    private WebElement ssn;

    @FindBy(xpath = "//input[@id='customer.username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='customer.password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registrationBtn;

    @FindBy(id="customer.username.errors")
    private WebElement userErrorExist;

    public UserRegistrationPage(WebDriver driver){
        super(driver);
    }

    public void enterRegistrationInfo(Map<String,String> map){
        firstName.sendKeys(map.get("firstName"));
        lastName.sendKeys(map.get("lastName"));
        address.sendKeys(map.get("address"));
        city.sendKeys(map.get("city"));
        state.sendKeys(map.get("state"));
        zipcode.sendKeys(map.get("zipcode"));
        phoneNumber.sendKeys(map.get("phoneNumber"));
        ssn.sendKeys(map.get("ssn"));
    }

    public UserHomePage enterUserPasswordAndRegister(Map<String,String> map) throws InterruptedException {
        do{
            username.sendKeys(map.get("usrename"));
            password.sendKeys(map.get("password"));
            confirmPassword.sendKeys(map.get("password"));
            registrationBtn.click();
            Thread.sleep(2000);

            if(existsElement(userErrorExist)){
               username.clear();
               String user = map.get("username")+Math.random();
               map.put("username",user);
            }

        }while(existsElement(userErrorExist));

        return new UserHomePage(driver);
    }

}
