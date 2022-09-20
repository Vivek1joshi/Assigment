package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SVGGraphHandle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        WebDriver driver = new ChromeDriver();
        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        String verticalxpath= "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
        String textpath="//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
        List<WebElement> listoftooltips = driver.findElements(By.xpath(verticalxpath));
        System.out.println("Size of the graph "+ listoftooltips.size());
        Actions action = new Actions(driver);
        for(WebElement e : listoftooltips){
            action.moveToElement(e).perform();
            // how to capture tooltip text
        String text =   driver.findElement(By.xpath(textpath)).getText();
            System.out.println(text);
        }
        driver.quit();
    }
}
