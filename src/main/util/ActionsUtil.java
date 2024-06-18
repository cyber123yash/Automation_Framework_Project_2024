package main.util;

import Javatestbase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ActionsUtil extends WebTestBase {


    public static Actions actions;
    public static void moveToWebElement(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element)
                .build()
                .perform();
    }
}
