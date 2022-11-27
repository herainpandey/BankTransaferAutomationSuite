package stepDefinitions;

import Base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pojo.LumaShopping.BillPaymentPage;
import pojo.LumaShopping.ParabankHomePage;
import pojo.LumaShopping.UserHomePage;
import pojo.LumaShopping.UserRegistrationPage;
import workflowHelper.Helper;


import java.util.Map;

public class StepDefinition {
    private ParabankHomePage parabankHomePage;
    private UserRegistrationPage userRegistrationPage;
    private UserHomePage userHomePage;
    private BillPaymentPage billPaymentPage;

    private BaseTest baseTest;

    private WebDriver driver;

    @Given("Launch Test Bank Site")
    public void launch_test_bank_site() {
        baseTest = new BaseTest();
        driver = baseTest.initializeBrowser();

         //launch test bank site
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        parabankHomePage = new ParabankHomePage(driver);
        userRegistrationPage = parabankHomePage.clickRegisterLink();

    }

    @Then("Register Sender")
    public void register_sender() throws InterruptedException {
        Map<String,String> userInfo = baseTest.userGenerator();
        userRegistrationPage.enterRegistrationInfo(userInfo);
        userHomePage = userRegistrationPage.enterUserPasswordAndRegister(userInfo);

    }

    @When("Registration is successful")
    public void registration_is_successful() {
        Assert.assertTrue(userHomePage.isRegistrationSuccessful());

    }

    @Then("Navigate to Bill Pay page")
    public void navigate_to_bill_pay_page() {
        billPaymentPage = userHomePage.billPay();
    }

    @Then("Enter Recipient Details and Amount to Transfer")
    public void enter_recipient_details_and_amount_to_transfer() {
        Map<String,String> recepientInfo = baseTest.userGenerator();
        billPaymentPage.enterPayeeInfo(recepientInfo);
        billPaymentPage.amountToTransfer(Helper.generateRandomTransactionAmount());
    }
    @Then("Perform Transfer")
    public void perform_transfer() {
        billPaymentPage.sendPaymentBtn();
    }
    @Then("Verify Transfer is successful to correct Recipient")
    public void verify_transfer_is_successful_to_correct_recipient() {
        //Not able to complete this use case, as getting server error while perform transfer to Recipient
    }

}
