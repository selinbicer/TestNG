package FridayProject4_12082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {

    public Elements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(css = "[value=\"Log in\"]")
    public WebElement loginBtn;

    @FindBy(className = "validation-summary-errors")
    public WebElement validationError;

    @FindBy(css = "[onclick*=\"('/addproducttocart/catalog/75/1/1\"]")
    public WebElement itemAddToCart;

    @FindBy(id = "product_attribute_75_5_31_96")
    public WebElement chooseprocesser;

    @FindBy(id = "product_attribute_75_6_32_99")
    public WebElement chooseRAM;

    @FindBy(id = "product_attribute_75_3_33_103")
    public WebElement chooseHDD;

    @FindBy(name = "product_attribute_75_8_35")
    public List<WebElement> softwareOptions;

    @FindBy(id = "add-to-cart-button-75")
    public WebElement addCartBtn;

    @FindBy(linkText = "Shopping cart")
    public WebElement shoppingCartLink;

    @FindBy(id = "termsofservice")
    public WebElement termsBtn;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(css = "[onclick=\"Billing.save()\"]")
    public WebElement continueBtn;

    @FindBy(css = "[onclick=\"Shipping.save()\"]")
    public WebElement continueBtn2;

    @FindBy(css = "[onclick=\"ShippingMethod.save()\"]")
    public WebElement continueBtn3;

    @FindBy(css = "[onclick=\"PaymentMethod.save()\"]")
    public WebElement continueBtn4;

    @FindBy(css = "[onclick=\"PaymentInfo.save()\"]")
    public WebElement continueBtn5;

    @FindBy(css = "[onclick=\"ConfirmOrder.save()\"]")
    public WebElement confirmBtn;

    @FindBy(className = "title")
    public WebElement confirmTitle;




}
