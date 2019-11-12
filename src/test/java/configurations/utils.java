package configurations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils{

    private static WebDriverWait wait = new WebDriverWait(Hooks.driver, 60);

    public utils(){
    }

    public Boolean waitElement(WebElement element) throws Throwable {
        Boolean result = false;
        int globalTimeout = 25;
        for (int i = 0; i < globalTimeout; i++) {
            try {
                element.isDisplayed();
                result = true;
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
            }
        }
        return result;
    }

    public void waitElementToBeClickable (String locator, String element) {
        try {
            switch (locator.toUpperCase()) {
                case "NAME":
                    wait.until(ExpectedConditions.elementToBeClickable(By.name(element)));
                    break;
                case "ID":
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
                    break;
                case "XPATH":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
                    break;
                case "CLASS":
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(element)));
                    break;
            }
        }catch (Exception e){
            System.out.println("-----------------------" + e.getMessage());
        }

    }

    public void waitVisibilityOfElementLocated (String locator, String element) {
        try {
            switch (locator.toUpperCase()) {
                case "NAME":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
                    break;
                case "ID":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
                    break;
                case "XPATH":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
                    break;
                case "CLASS":
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(element)));
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("------------------- " + e.getMessage());
        }
    }

    public void waitInVisibilityOfElementLocated (String locator, String element) {
        switch (locator.toUpperCase()) {
            case "NAME":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(element)));
                break;
            case "ID":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element)));
                break;
            case "XPATH":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
                break;
            case "CLASS":
                wait.until(ExpectedConditions.elementToBeClickable(By.className(element)));
                break;
        }
    }

    public void waitPresenceOfElementLocated (String locator, String element) {
        try {
            switch (locator.toUpperCase()) {
                case "NAME":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.name(element)));
                    break;
                case "ID":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
                    break;
                case "XPATH":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
                    break;
                case "CLASS":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.className(element)));
                    break;
            }
        }catch (Exception e){
            System.out.println("--------------------------" + e.getMessage());
        }

    }

    public void select(WebElement cmb, String by, String text) {
        switch (by) {
            case "index":
                new Select(cmb).selectByIndex(Integer.parseInt(text));
                break;
            case "value":
                new Select(cmb).selectByValue(text);
                break;
            case "element":
                new Select(cmb).selectByVisibleText(text);
                break;
        }
    }

    public WebElement returnFirstSelectedOption(WebElement select) {
        WebElement elementCombo = ((Select) select).getFirstSelectedOption();
        return elementCombo;
    }


}
