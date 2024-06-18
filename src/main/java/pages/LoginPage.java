package pages;

import Javatestbase.WebTestBase;
import main.util.WaitUtil;
import main.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends WebTestBase {

    @FindBy(id = "username")
    WebElement loginUserNameTextBox;

    @FindBy(id = "password")
    WebElement loginPasswordTextBox;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//strong[text()='ERROR']")
    WebElement errorElement;


    public LoginPage(){
        PageFactory.initElements(driver, this);

    }

    public void login(String userName, String password){
        WebDriverUtil.sendKeysToElement(loginUserNameTextBox, userName);
        WebDriverUtil.sendKeysToElement(loginPasswordTextBox, password);
        WaitUtil.waitUntilElementToBeClickable(loginBtn);
    }

    public String getTextOfErrorElement(){
        WaitUtil.waitUntilElement(errorElement);
        return WebDriverUtil.getTextOfElement(errorElement);
    }

}
