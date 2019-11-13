package TestNGData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoginTest {


    protected WebDriver driver;
    public static String randomDate()
    { DateFormat format =new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());}

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        //driver.get("http://demo.nopcommerce.com");
    }
     @AfterMethod
    public void closeBrowser(){
        driver.quit();
}


@DataProvider
public Object[][] getRegisterData(){

        Object data [][]= Utils.getTestData("register");

    return data;
}

@Test(dataProvider = "getRegisterData")
    public void registerTest(String Test,String Data){

    //enter first name
    driver.findElement(By.id("txtUsername")).sendKeys("username");

    //enter password
    driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("password");

    //click on login
    driver.findElement(By.id("btnLogin")).click();
}


}
