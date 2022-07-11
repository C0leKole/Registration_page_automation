package tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BasicTest {
    protected WebDriver driver;
    protected String baseUrl = "https://etherscan.io/register";
    protected RegistrationPage registrationPage;
    protected MessagePopUpPage messagePopUpPage;
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        registrationPage = new RegistrationPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
