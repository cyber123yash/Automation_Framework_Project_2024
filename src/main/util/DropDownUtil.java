package main.util;

import Javatestbase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownUtil extends WebTestBase {

        public static Select select;


        public static void bootstrapDropDown(List<WebElement> elementList,String option){
            for(WebElement element : elementList){
                if(element.getText().equalsIgnoreCase(option)){
                    element.click();
                    break;
                }
            }
        }

}
