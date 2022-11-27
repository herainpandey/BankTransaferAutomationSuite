package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class BillPaymentPage extends Base {
    @FindBy(xpath = "//input[@name='payee.name']")
    private WebElement payee_name;

    @FindBy(xpath ="//input[@name='payee.address.street']")
    private WebElement address;

    @FindBy(xpath ="//input[@name='payee.address.city']")
    private WebElement city;

    @FindBy(xpath ="//input[@name='payee.address.state']")
    private WebElement state;

    @FindBy(xpath ="//input[@name='payee.address.zipCode']")
    private WebElement zipcode;

    @FindBy(xpath ="//input[@name='payee.phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(xpath ="//input[@name='payee.accountNumber']")
    private WebElement account;

    @FindBy(xpath ="//input[@name='verifyAccount']")
    private WebElement verifyAccount;

    @FindBy(xpath ="//input[@name='amount']")
    private WebElement transfer_amount;

    @FindBy(xpath = "//select[@name='fromAccountId']")
    private WebElement fromAccount;

    @FindBy(xpath ="//input[@value='Send Payment']")
    private WebElement sendPayment;


    public BillPaymentPage(WebDriver driver){
        super(driver);
    }

    public void enterPayeeInfo(Map<String,String> payeeMap){
        payee_name.sendKeys(payeeMap.get("firstName"));
        address.sendKeys(payeeMap.get("address"));
        city.sendKeys(payeeMap.get("city"));
        state.sendKeys(payeeMap.get("state"));
        zipcode.sendKeys(payeeMap.get("zipcode"));
        phoneNumber.sendKeys(payeeMap.get("phoneNumber"));
        account.sendKeys(payeeMap.get("account"));
        verifyAccount.sendKeys(payeeMap.get("account"));

    }

     public void amountToTransfer(String amount){
         transfer_amount.sendKeys(amount);
    }

    public void sendPaymentBtn(){
        sendPayment.click();
    }


}
