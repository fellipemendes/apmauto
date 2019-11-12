package configurations;

import org.openqa.selenium.WebDriver;

public class driverFactory {

    private static WebDriver driver;

    public driverFactory(){}

    public static WebDriver getDriver(){
        return driver;
    }
}
