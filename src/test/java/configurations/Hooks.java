package configurations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    public Hooks(){}

    @Before
    public void setUp(){
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("---------------------------" + e.getMessage());
        }
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
