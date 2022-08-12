package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralWebDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
     public void startingOperations(){
        System.out.println("Driver start...");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //2.kısım proje içerisindeki yerini gösteriyor
        driver = new ChromeDriver();

        //driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        //driver.manage().window().maximize(); // max
        driver.manage().deleteAllCookies();  //

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //loginTest();

    }

    @AfterClass
   public void exitOperations(){
        System.out.println("Driver stop...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    void loginTest(){
        // driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement email = driver.findElement(By.cssSelector("input[id='input-email']"));
        email.sendKeys("s@abc.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("selKKK");
        WebElement loginBtn = driver.findElement(By.cssSelector("[value='Login']"));
        loginBtn.click();

    }
}
