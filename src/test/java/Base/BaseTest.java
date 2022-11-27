package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pojo.UserGenerator.UserGenerator;

import workflowHelper.Helper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class BaseTest{

    private static WebDriver driver;
    @Before
    public static WebDriver initializeBrowser(){
        //Log.info("Initializing Chrome Browser");
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public Map<String, String> userGenerator() {

        Map<String, String> userMap = new HashMap<String, String>();;
        try {
            // Generate Sender Data
            UserGenerator user = given().when().get("https://randomuser.me/api").then().extract().response().getBody().as(UserGenerator.class);
            userMap.put("firstName", user.getResults().get(0).getName().getFirst());
            userMap.put("lastName", user.getResults().get(0).getName().getLast());
            userMap.put("address", user.getResults().get(0).getLocation().getStreet().getName());
            userMap.put("city", user.getResults().get(0).getLocation().getCity());
            userMap.put("state", user.getResults().get(0).getLocation().getState());
            userMap.put("zipcode", user.getResults().get(0).getLocation().getPostcode());
            userMap.put("phoneNumber", user.getResults().get(0).getPhone());
            userMap.put("ssn", Helper.generateRandomSSNNumber());
            userMap.put("account", Helper.generateRandomAccount());
            userMap.put("username", user.getResults().get(0).getLogin().getUsername());
            userMap.put("password", user.getResults().get(0).getLogin().getPassword());
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
        return userMap;
    }

    @After
    public static  void closeBrowser(){
        driver.quit();
    }

}
