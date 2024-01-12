package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AizadaPages {
    public WebDriver driver;

    public AizadaPages(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//button[@type='button'][1]")
    public WebElement singIn;



    @FindBy(xpath = "//input[@name='email'])[2]")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement singIn2;



    @FindBy(xpath = "//*[text()='Reports']")
    public WebElement reports;

    @FindBy(id="active")
    public WebElement Transactions;


    @FindBy(xpath = "//button[@type='button'][1]")
    public WebElement addIncome;


    @FindBy(xpath = "//div[@class='css-dn4d12'][1]")
    public WebElement paymentDate;

    @FindBy(xpath ="//input[@name='name_of_payment']")
    public WebElement titleField;

    @FindBy(xpath = "//div[@id='mui-component-select-category_id']")
    public WebElement categoryField;
    @FindBy(xpath = "//button[@aria-readonly='true']")
    public WebElement createNewCategory;
    @FindBy(id=":rf:")
    public  WebElement   title;
    @FindBy(id = ":rg:")
    public WebElement description;
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[text()='Job'][1]")
    public WebElement category;
    @FindBy(xpath = "mui-component-select-category_id")
    public WebElement jobField;



    @FindBy(id = ":r36:")
    public WebElement writeTitle;

    @FindBy(id = ":r37:")
    public  WebElement balanceField;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement save;

    @FindBy(id=":r35:")
    public WebElement sum;
    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement acceptButton;
}

