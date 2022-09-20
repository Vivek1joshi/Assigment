package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='form-group']//following::input[@class='form-control ng-pristine ng-invalid ng-touched']")
    private WebElement Username;
    @FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-invalid']")
    private WebElement Email;
    @FindBy(linkText = "//div[@class='form-group']//following::input[@type='password']")
    private WebElement Password;
    @FindBy(xpath = "//div[@class='form-group']//following::input[@type='checkbox']")
    private WebElement Select_Checkbox;
    @FindBy(xpath = "//select[@class='form-control']")
    private WebElement Click_On_Gender;
    @FindBy(xpath = "//select[@class='form-control']")
    private WebElement Click_On_Radiobutton;
    //  private static final String Radio_button = "(//div[@class='form-check form-check-inline']//following::input[@class='form-check-input'])[%d]";
    @FindBy(xpath = "//input[@type='date']")
    private WebElement Click_On_DateofBirth;
    @FindBy(xpath = "//input[@type='date']")
    private WebElement Click_On_Submitbutton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SignUp(String url) {
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        ExtentLogger.pass("Enter username:- " + url);
        action.moveToElement(Username).sendKeys("Admin");
        ExtentLogger.pass("Enter username:- " + Username);
        action.moveToElement(Email).sendKeys("vivekjoshi@yopmail.com");
        ExtentLogger.pass("Enter username:- " + Email);
        action.moveToElement(Password).sendKeys("Vivek@123");
        ExtentLogger.pass("Enter username:- " + Password);
        action.moveToElement(Select_Checkbox).click();
        action.moveToElement(Click_On_Gender).click();
        Select gender = new Select(Click_On_Gender);
        gender.selectByVisibleText("Male");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//following::input[@class='form-check-input']"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(list.size());
        list.get(randomProduct).click();
        Click_On_DateofBirth.click();
        Click_On_Submitbutton.click();
    }

    public void VerifyHomePage() {
        String actual = driver.getCurrentUrl();
        String expected = "https://rahulshettyacademy.com/angularpractice/";
        Assert.assertEquals(actual, expected, "Home page is not verified");
    }
}
