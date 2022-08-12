package FridayProject4_12082022;

import Utils.ParameterWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenarios extends ParameterWebDriver {



    /*
 -You should navigate to the Login page and try to login with valid credentials.
 -Expected Result is successfully login!
  */

    @Test (priority = 1)
    void scenario1(){

        Elements e = new Elements(driver);

        e.loginLink.click();
        wait.until(ExpectedConditions.visibilityOf(e.email)).sendKeys("technostudygrup16@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(e.password)).sendKeys("123456");
        e.loginBtn.click();
    }

    /*
    -You should navigate to the Login page and try to login with invalid credentials.
        -Expected Result is “Login was unsuccessful. Please correct the errors and try again.
        ● No customer account found” message should be displayed. Validate this message is
        displayed and validate text.
     */

    @Test (priority = 2)
    void scenario2(){

        Elements e = new Elements(driver);

        e.loginLink.click();
        wait.until(ExpectedConditions.visibilityOf(e.email)).sendKeys("abc@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(e.password)).sendKeys("dfdfds");
        e.loginBtn.click();

        Assert.assertEquals(e.validationError.getText(),
                "Login was unsuccessful. Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect");

    }
    /*
    SCENARIO 3 - Place an Order:
    -You should navigate to the website and login to your account.
    -You should select a product from HomePage and add to cart
    -You should complete proceed to checkout process
    -At the end you should verify the following success message! “Your order has been
    successfully processed!”
     */

    @Test (priority = 3)
    void scenario3(){
        Elements e = new Elements(driver);

        e.loginLink.click();
        wait.until(ExpectedConditions.visibilityOf(e.email)).sendKeys("technostudygrup16@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(e.password)).sendKeys("123456");
        e.loginBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(e.itemAddToCart)).click();
        wait.until(ExpectedConditions.urlContains("simple-computer"));

        e.chooseprocesser.click();
        e.chooseRAM.click();
        e.chooseHDD.click();
        for (WebElement we : e.softwareOptions)
            we.click();

        e.addCartBtn.click();
        e.shoppingCartLink.click();
        e.termsBtn.click();
        e.checkoutBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(e.continueBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.continueBtn2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.continueBtn3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.continueBtn4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.continueBtn5)).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.confirmBtn)).click();

        wait.until(ExpectedConditions.urlContains("checkout/completed/"));

        Assert.assertEquals(e.confirmTitle.getText(),"Your order has been successfully processed!");
    }
}
