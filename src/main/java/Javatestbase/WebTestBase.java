package Javatestbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static main.util.WaitUtil.PAGE_LOAD;
import static org.testng.reporters.jq.BasePanel.C;

public class WebTestBase {

    public static Properties prop;

    public static WebDriver driver;

    public WebTestBase()  {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        }catch (Exception e){
            e.printStackTrace();
        }
        prop = new Properties();

        try {
            prop.load(fileInputStream);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/browser/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/browser/geckodriver.exe");
            driver = new FirefoxDriver();
            
        } else {
            throw new RuntimeException("Please select the correct browser name");
        }
        driver.get((prop.getProperty("url")));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD));
        driver.manage().deleteAllCookies();
    }




}
