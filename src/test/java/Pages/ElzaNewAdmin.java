package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElzaNewAdmin {
    public WebDriver driver;

    public ElzaNewAdmin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement signInBtn;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement logInEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement logInPassword;


    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement confirmSignInBtn;

    @FindBy(xpath = "//p[text()='Admin Codewise']")
    public WebElement adminCodewiseBtn;

    @FindBy(xpath = "//button[text()='Create account']")
    public WebElement createAccount;


    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement name;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone_number']")
    public WebElement phoneNum;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='repeat_password']")
    public WebElement repeatPassword;

    @FindBy(xpath = "//input[@value='CASHIER']")
    public WebElement cashier;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createBtn;

    @FindBy(xpath = "//li[text()='Log out']")
    public WebElement logOut;

    @FindBy(xpath = "//button[text()='Log out']")
    public WebElement confirmLogOut;
}
