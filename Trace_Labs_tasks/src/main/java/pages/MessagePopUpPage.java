package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getInvalidCaptchaResponse () {
        return driver.findElement(By.partialLinkText("Error! Invalid captcha"));

    }
}
