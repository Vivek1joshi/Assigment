package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploading {
    static WebDriver driver;

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("//div[@class='col-xs-6 col-xs-offset-6']//following::input[@id='imagesrc'].click();");
       driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-6']//following::input")).click();
        robot.setAutoDelay(2000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\VivekJoshi\\Desktop\\Git.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.quit();
    }
}
