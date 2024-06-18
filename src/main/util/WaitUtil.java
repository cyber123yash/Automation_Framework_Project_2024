package main.util;

import Javatestbase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WaitUtil extends WebTestBase {

    public static long PAGE_LOAD = 40;

    public static long EXPLICIT_WAIT = 40;
    public static WebDriverWait wait;

    public static void waitUntilElementToBeClickable(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitUntilElement(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElement(List<WebElement> elements){
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
