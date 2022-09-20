package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotCLass {
    // common usecases for using robot class
    //1.robot.keypress(KeyEvent.vk_Down)
    //2.robot.keypress(KeyEvent.vk_Tab)
    //3.robot.keypress(KeyEvent.vk_Enter)
    static WebDriver driver;
//    public static void main(String[] args) {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
////        ChromeOptions co = new ChromeOptions();
////        co.addArguments("--headless");
//        driver.get("https://emicalculator.net/");
//        driver.manage().window().maximize();
//    }
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();
        driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url
        driver.findElement(By.xpath(".//a[@href=contains(text(),'yearly-calendar.xls')]")).click();
        Robot robot = new Robot();  // Robot class throws AWT Exception
        Thread.sleep(2000); // Thread.sleep throws InterruptedException
        robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button
        Thread.sleep(2000);  // sleep has only been used to showcase each event separately
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        // press enter key of keyboard to perform above selected action
    }
}

