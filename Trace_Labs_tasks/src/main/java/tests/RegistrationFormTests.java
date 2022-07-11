package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationFormTests extends BasicTest {
    @Test(priority = 10)
    public void validRegistrationTC01() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola04");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");

        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        Thread.sleep(10000); //time for manually clicking Captcha button
        registrationPage.getCreateAccountButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Your account registration has been submitted " +
                        "and is pending email verification ')]")));
    }

    @Test(priority = 20)
    public void displayErrorWhenCaptchaIsNotClickedTC02() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");

        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        registrationPage.getCreateAccountButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.partialLinkText("Please Try Again")));

    }

    @Test(priority = 30)
    public void displayErrorWhenIAgreeWithTermsIsNotClickedTC03() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");


        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());
        registrationPage.getCreateAccountButton().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ctl00$ContentPlaceHolder1$MyCheckBox-error")));
    }

    @Test(priority = 40)
    public void displayErrorWhenEmailIsInvalidTC04() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");

        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        registrationPage.getCreateAccountButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ContentPlaceHolder1_txtConfirmEmail-error")));
    }
    @Test(priority = 50)
    public void displayErrorWhenPassowordsDontMatchTC05() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123");

        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        registrationPage.getCreateAccountButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ContentPlaceHolder1_txtPassword2-error")));
    }
    @Test(priority = 60)
    public void displayErrorWhenEmailsDontMatchTC06() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic1@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123");

        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        registrationPage.getCreateAccountButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ContentPlaceHolder1_txtConfirmEmail-error")));
    }
    @Test(priority = 70)
    public void displayErrorWhenUsernameIsAlreadyExistingTC07() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");

        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        Thread.sleep(5000); //time for manually clicking Captcha button

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        registrationPage.getCreateAccountButton().click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(text(), 'Sorry! The username you entered is already in use.')]")));
    }
    @Test(priority = 80)
    public void displayErrorWhenPasswordInputIsEmptyTC08() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");


        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        Thread.sleep(5000); //time for manually clicking Captcha button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        registrationPage.getCreateAccountButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(text(), 'Your password must be at least 5 characters long.')]")));
    }
    @Test(priority = 90)
    public void displayErrorWhenSpecialCharactersAreInUsernameTC09() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikola03$#");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");


        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        Thread.sleep(5000); //time for manually clicking Captcha button

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        registrationPage.getCreateAccountButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(text(), 'Username is invalid.')]")));
    }
    @Test(priority = 100)
    public void displayErrorWhenUsernameHasLessThan5CharsTC10() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("ni93");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");


        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        Thread.sleep(5000); //time for manually clicking Captcha button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        registrationPage.getCreateAccountButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(text(), 'Username is invalid.')]")));
    }
    @Test(priority = 110)
    public void validRegistrationWithMoreThan30charsTC11() throws InterruptedException {
        registrationPage.getUsernameInput().click();
        registrationPage.getUsernameInput().sendKeys("nikolailic123123123123123123123123123123123");
        registrationPage.getEmailInput().click();
        registrationPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getConfirmEmailInput().click();
        registrationPage.getConfirmEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        registrationPage.getPasswordInput().click();
        registrationPage.getPasswordInput().sendKeys("test123test");
        registrationPage.getConfirmPasswordInput().click();
        registrationPage.getConfirmPasswordInput().sendKeys("test123test");


        JavascriptExecutor iAgreeWithTerms = (JavascriptExecutor) driver;
        iAgreeWithTerms.executeScript("arguments[0].click()", registrationPage.getIAgreeWithTermsCheckbox());
        JavascriptExecutor newsLetter = (JavascriptExecutor) driver;
        newsLetter.executeScript("arguments[0].click()", registrationPage.getIAgreeToReceiveNewsLetterCheckbox());

        Thread.sleep(10000); //time for manually clicking Captcha button

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        registrationPage.getCreateAccountButton().click();


    }

}
