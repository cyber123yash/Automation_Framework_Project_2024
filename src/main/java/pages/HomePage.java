package pages;

import Javatestbase.WebTestBase;
import main.util.ActionsUtil;
import main.util.WaitUtil;
import main.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Javatestbase.WebTestBase.driver;

public class HomePage extends WebTestBase {

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement firstAd;

    @FindBy(xpath = "//li[@class='user-controls__ul__li user-controls__ul__li--account']")
    WebElement myAccountBtn;

    @FindBy(xpath = "//li[@class='user-controls__ul__li user-controls__ul__li--cart']" )
    WebElement addToCardBtn;

    @FindBy(xpath = "//a[text()='Shop']")
    WebElement ShopOption;

    @FindBy(xpath = "//ul[@class='sub-menu'])[2]//li/a")
    List<WebElement> allShopOptions;

    @FindBy(xpath = "")
    List<WebElement> allElement;



    public  HomePage(){

        PageFactory.initElements(driver, this);
    }

    public void closedFirsAd(){
        WaitUtil.waitUntilElementToBeClickable(firstAd);

    }

    public void clickOnMyAccountBtn(){

        WaitUtil.waitUntilElementToBeClickable(myAccountBtn);
    }


    public void selectShopOptions(String option){
        WaitUtil.waitUntilElement(ShopOption);
        ActionsUtil.moveToWebElement(ShopOption);
        WaitUtil.waitUntilElement(allShopOptions);
        WebDriverUtil.selectRandomOptionInList(allElement, option);
    }

}
