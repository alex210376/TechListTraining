package techList.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    protected Properties properties;
    protected String login;
    protected String password;
    protected String numberOflines;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws IOException {
        properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("common.properties"));
        baseUrl = properties.getProperty("baseUrl");
        login = properties.getProperty("login");
        password = properties.getProperty("password");
        numberOflines = properties.getProperty("numberOflines");
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
                driver = new FirefoxDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", properties.getProperty("opera.driver"));
                driver = new OperaDriver();
                break;
        }
    }


    @AfterMethod(alwaysRun = true)
    public void Down() {
        driver.quit();
    }
}
