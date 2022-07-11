package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUsernameInput () {
        return driver.findElement(By.id("ContentPlaceHolder1_txtUserName"));
    }
    public WebElement getEmailInput () {
       return driver.findElement(By.id("ContentPlaceHolder1_txtEmail"));
    }
    public WebElement getConfirmEmailInput () {
        return driver.findElement(By.id("ContentPlaceHolder1_txtConfirmEmail"));
    }
    public WebElement getPasswordInput () {
        return driver.findElement(By.id("ContentPlaceHolder1_txtPassword"));
    }
    public WebElement getConfirmPasswordInput () {
        return driver.findElement(By.id("ContentPlaceHolder1_txtPassword2"));
    }
    public WebElement getIAgreeWithTermsCheckbox () {
        return driver.findElement(By.id("ContentPlaceHolder1_MyCheckBox"));
    }
    public WebElement getIAgreeToReceiveNewsLetterCheckbox () {
        return driver.findElement(By.id("ContentPlaceHolder1_SubscribeNewsletter"));
    }
    public WebElement getCreateAccountButton () {
        return driver.findElement(By.id("ContentPlaceHolder1_btnRegister"));
    }
    public WebElement getCaptchaBox () {
        return driver.findElement(By.xpath("//iframe[contains(@name, 'a-4l8g4amcfv9q')]"));
    }

}
