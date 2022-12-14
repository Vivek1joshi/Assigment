package Test;

import Pages.PageFactory;
import ReadExcelData.ExcelDataConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;

public class BaseTest {
    private static WebDriver driver;
    protected PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public void setUp(String browserName) throws IOException {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
//            String Node = "http://10.10.30.53:4444/wd/hub";
//            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setBrowserName("chrome");
//            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.get("https://rahulshettyacademy.com/angularpractice/");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        }
    }

    public static WebDriver getDrivers() {
        return driver;
    }

    @AfterClass
    public void tearDown() throws IOException {
        driver.quit();
    }

    @DataProvider(name = "WebsiteLoginData")
    public Object[][] passData() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig("TestData/new.xls");
        int rows = config.getRowCount(0);
        int cols = config.getCellCount(0, 1);
        String[][] data = new String[rows][cols];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = config.getData(0, i, j);
            }
        }
        return data;
    }
}

