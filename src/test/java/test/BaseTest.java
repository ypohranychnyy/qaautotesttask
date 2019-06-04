package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.HomePage;
import page.SearchResultsPage;

public class BaseTest {
    protected SearchResultsPage searchResultsPage;
    protected HomePage homePage;
    protected WebDriver driver;


    @BeforeMethod

    @Parameters("browser")

    public void beforeMethod(@Optional("chrome") String browserName) throws Exception {
        if (browserName.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.toLowerCase().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            throw new Exception("Unsupported 'BrowserName'");
        }

        driver.manage().window().maximize();
        driver.get("http://google.com");
        homePage = new HomePage(driver);

    }


    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
