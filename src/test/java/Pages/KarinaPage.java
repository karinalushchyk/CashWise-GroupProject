package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KarinaPage {
    public WebDriver driver;

    public KarinaPage (WebDriver driver){
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
    @FindBy(xpath ="//li[text()='Sales']")
    public WebElement salesButton;

    @FindBy (xpath = "//a[text()='Invoice']")
    public  WebElement invoiceButton;

    @FindBy( id = "mui-component-select-status")
     public WebElement status;

    @FindBy (xpath = "(//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-1msxoye'])[2]")
    public WebElement NotPaidStatus;

    @FindBy (xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")
    public WebElement selectBox1;

    @FindBy (xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")
    public WebElement selectBox2;

    @FindBy (xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]")
    public WebElement selectBox3;

    @FindBy (xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[5]")
    public WebElement selectBox4;

    @FindBy (xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[6]")
    public WebElement selectBox5;

    @FindBy (xpath = "//button[@class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButtonBase-root sc-jqUVSM iOqmyu css-4t6ilf']")
    public WebElement deleteSelected;

    @FindBy (xpath = "(//button[@type='button'])[1]")
    public  WebElement createInvoiceButton;

    @FindBy (xpath = "//input[@name='invoice_title']")
    public WebElement invoiceName;

    @FindBy (xpath = "//div[@class=' css-1jkhjy1-control']" )
    public  WebElement whomButton;

    @FindBy (xpath = "(//div[@class='MuiFormControl-root MuiTextField-root css-1d1skhv'])[2]")
    public WebElement payUntil;

    @FindBy (xpath = "//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall MuiInputBase-multiline css-1gv5z4s']")
    public  WebElement description;

    @FindBy (xpath = "//div[@class=' css-11unzgr']")
    public WebElement pickTitle;

    @FindBy (xpath = "(//th[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight MuiTableCell-sizeMedium css-2vc9sa'])[1]")
    public WebElement totalSum;

    @FindBy (xpath = "(//th[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight MuiTableCell-sizeMedium css-2vc9sa'])[2]")
    public  WebElement sumOfDiscount;

    @FindBy (xpath = "//th[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight MuiTableCell-sizeMedium css-5e7dut']")
    public  WebElement total;

    @FindBy (xpath = "//button[@class='MuiButton-root MuiButton-BORDERED MuiButton-BORDEREDPrimary MuiButton-sizeMedium MuiButton-BORDEREDSizeMedium MuiButtonBase-root css-g7im2v']")
    public WebElement selectProductButton;
    @FindBy (xpath = "//div[@class='sc-dkzDqf gCnaQD']")
    public  WebElement CodeWise;
    @FindBy (xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-xdzsgw']")
    public  WebElement saveButton;

    @FindBy (xpath = "(//button[@class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButtonBase-root sc-iqcoie fOawlg not-paid css-4t6ilf'])[1]")
    public  WebElement acceptPayment;


    @FindBy (xpath = "//input[@placeholder='File title']")
    public  WebElement fileTitle;

    @FindBy (id = "mui-component-select-type_of_pay")
    public WebElement selectPaymentMethod;


    @FindBy (xpath = "(//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-1msxoye'])[1]")
    public WebElement cash;

    @FindBy (id = "mui-component-select-bank_account")
    public  WebElement toWhichCheck;

    @FindBy( xpath = "//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-1msxoye']")
    public WebElement jj;

    @FindBy( name = "comment")
    public WebElement comment;

    @FindBy (xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-7467wi']")
    public WebElement saveButton2;


}
