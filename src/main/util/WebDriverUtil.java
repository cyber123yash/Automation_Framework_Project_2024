package main.util;

import Javatestbase.WebTestBase;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebDriverUtil extends WebTestBase {


    public static void sendKeysToElement(WebElement element, String text){
        element.sendKeys(text);
    }

    public static String getTextOfElement(WebElement element){
        return element.getText();
    }

    public static String getTextOfErrorElement(WebElement element) {
        return element.getText();
    }

    public static void selectRandomOptionInList(List<WebElement> elementList, String option){
        for(WebElement element : elementList){
            if(element.getText().equalsIgnoreCase(option)){
                element.click();
                break;
            }
        }
    }
}
