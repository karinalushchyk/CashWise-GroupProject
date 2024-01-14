package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Config;
import utilities.Driver;

public class Report_chart_page {
    WebDriver driver;

    public Report_chart_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Reports']")
    public WebElement reports;

    @FindBy(xpath = "//*[text()='Report chart']")
    public  WebElement reportChart;

    @FindBy(xpath = "(//*[@height='22'])[3]")
    public  WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Delete']")
    public  WebElement clickDeleteButton;


    @FindBy(xpath = "//*[@id='mui-component-select-type_of_pay']")
    public WebElement paymentMethod;

    @FindBy(xpath = "//li[text()='Cash']")
    public WebElement cashButton;

    @FindBy(xpath = "//*[text()='Create new invoice']")
    public WebElement createNewInvoice;

    @FindBy(xpath = "//input[@name='bank_account_name']")
    public WebElement newInvoiceTitle;

    @FindBy(xpath = "//input[@name='balance']")
    public WebElement newInvoiceBalance;

    @FindBy(xpath = "//*[text()='Save']")
    public  WebElement newInvoiceSaveButton;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;


    public void setUpSignIn() throws InterruptedException {
        driver.get(Config.getValue("cashwise.url"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(Config.getValue("cashwise.email"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Config.getValue("cashwise.password"));
        driver.findElement(By.xpath("(//button[text()='Sign in'])[2]")).click();


    }




}
