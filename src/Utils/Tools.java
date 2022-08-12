package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools {

    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuActualList){
        for (int i = 0; i < menuExpectedList.size(); i++) {
            Assert.assertEquals(menuExpectedList.get(i), menuActualList.get(i).getText(),"Result of Comparing");
        }
    }

    public static void successMessageValidation(){
        WebElement alert = GeneralWebDriver.driver.findElement(By.cssSelector("[class=\"alert alert-success alert-dismissible\"]"));
        Assert.assertTrue(alert.getText().toLowerCase().contains("success"));
    }

    public static void wait(int seconds)
    {
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void editAccount(String s1, String s2) {
        By editAcc = By.linkText("Edit Account");
        By name = By.id("input-firstname");
        By lastN = By.id("input-lastname");

        WebElement accEdit = GeneralWebDriver.driver.findElement(editAcc);
        accEdit.click();
        WebElement firstName = GeneralWebDriver.driver.findElement(name);
        firstName.clear();
        firstName.sendKeys(s1);
        WebElement lastName = GeneralWebDriver.driver.findElement(lastN);
        lastName.clear();
        lastName.sendKeys(s2);
        WebElement cnt = GeneralWebDriver.driver.findElement(By.cssSelector("input[value=\"Continue\"]"));
        cnt.click();
        Tools.successMessageValidation();
    }
    public static void editElement(WebElement e1, String s1) {
        e1.clear();
        e1.sendKeys(s1);
    }

    public static double webelementToDouble(WebElement w){
        return Double.parseDouble(w.getText().replaceAll("[^0-9]",""));
    }

    public static int randomGenerator(int max){
        return (int)(Math.random()*max);
    }
}
