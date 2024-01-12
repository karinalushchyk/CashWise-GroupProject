package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.UtilWait;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SalesPage {

    public WebDriver driver;
    public SalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//li[text()='Sales']")
    public WebElement sales;

    @FindBy(xpath = "//a[text()='Clients']")
    public WebElement clients;

    @FindBy(xpath = "//a[@href='/dashboard/sales/products-and-services']")
    public WebElement productsAndServices;

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-pmdq9']")
    public WebElement underProductsAndServicesAddProdORService;

    @FindBy(xpath = "//input[@placeholder='Write name']")
    public WebElement underProductsAndServicesAddProdORServiceNameField;

    @FindBy(xpath = "//input[@placeholder='Write price']")
    public WebElement underProductsAndServicesAddProdORServicePriceField;

    @FindBy(xpath = "//div[@aria-haspopup='listbox']")
    public WebElement underProductsAndServicesAddProdORServiceSelectType;

    @FindBy(xpath = "//li[text()='Product']")
    public WebElement underProductsAndServicesAddProdORServiceServiceTypeProduct;

    @FindBy(xpath = "//div[text()='Сервис successfully created']")
    public WebElement underProductsAndServicesPopUpService;

    @FindBy(xpath = "//div[text()='Продукт successfully created']")
    public WebElement underProductsAndServicesPopUpProd;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement underProductsAndServicesSaveButton;

    @FindBy(xpath = "//li[text()='Service']")
    public WebElement underProductsAndServicesAddProdORServiceServiceTypeService;

    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
    public WebElement underProductsAndServicesAddProdORServiceSelectCategory;

    @FindBy(xpath = "//a[@href='/dashboard/sales/invoice/invoices']")
    public WebElement invoice;

    @FindBy(xpath = "//button[text()='Import from XLS']")
    public WebElement importFromXLSButton;

    @FindBy(xpath = "//button[text()='Add client']")
    public WebElement addClientButton;

    @FindBy(xpath = "(//div[text()='Select tag'])[2]")
    public WebElement underAddClientTagSelect;

    @FindBy(xpath = "//input[@placeholder='Company name']")
    public WebElement underAddClientCompanyNameField;

    @FindBy(xpath = "//input[@placeholder='Write full name']")
    public WebElement underAddClientFullNameField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement underAddClientEmailField;
    @FindBy(xpath = "//input[@placeholder='+996 ___ __ __ __ ']")
    public WebElement underAddClientPhoneNumberField;

    @FindBy(xpath = "//input[@placeholder='Write address']")
    public WebElement underAddClientAddressField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement underAddClientSaveButton;

    @FindBy(xpath = "//a[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary Mui-selected css-1wt3xuk']")
    public WebElement clientsActive;

    @FindBy(xpath = "//*[contains(text(),'Client created successfully')]")
    public WebElement clientNotif;



    @FindBy(xpath = "//input[@placeholder='Enter email, title or name']")
    public WebElement enterEmailTitleNameField;

    @FindBy(xpath = "//div[@class=' css-ackcql']")
    public WebElement selectTag;

    @FindBy(xpath = "//div[@role='tablist']//a[@href='/dashboard/sales/clients/active']")
    public WebElement active;

    @FindBy(xpath = "//a[@href='/dashboard/sales/clients/archieved']")
    public WebElement archived;

    @FindBy(xpath = "//div[@style='padding-left: 15px;']//button")
    public WebElement underActiveButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement underActiveCheckbox;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement archiveAllCheckbox;

    @FindBy(xpath = "//button[text()='Archive']")
    public WebElement archiveButton;


    /**
     * below are methods related to the Sales page
     */
    public void addClientWithExistingTag() throws IOException {

        sales.click();
        Random random = new Random();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));



        String strActiveBefore = clientsActive.getText();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(clientsActive, strActiveBefore))));
        strActiveBefore = clientsActive.getText();

        int counterActiveBefore = Integer.parseInt(strActiveBefore.replaceAll("[\\D]", ""));

        addClientButton.click();

        Faker faker = new Faker();

        Actions actionsTest = new Actions(driver);
        actionsTest.click(underAddClientTagSelect).pause(500).sendKeys(Keys.ENTER).perform();

        underAddClientCompanyNameField.sendKeys("CompanyTest" + Date.from(Instant.now()));
        underAddClientFullNameField.sendKeys("Joe Doe");

       // underAddClientEmailField.sendKeys("joe" + random.nextInt(1,1000) + "doe@test.com");
        underAddClientEmailField.sendKeys(faker.commerce().promotionCode()+ "@test.com");
        //underAddClientPhoneNumberField.sendKeys(random.nextInt(111111111,999999999) + "");
        underAddClientPhoneNumberField.sendKeys(faker.phoneNumber().cellPhone());
        underAddClientAddressField.sendKeys(random.nextInt(1,1234) + " Test St");
        underAddClientSaveButton.click();


        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(clientsActive, strActiveBefore)));

        try{
            wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Client created successfully')]")));
        }catch(Throwable e){
            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
        }


        UtilWait.takeScreenshot(driver,"src/test/java/screenshots/AddClientTest.png");
        String strNotif = clientNotif.getText();

        String strActiveAfter = clientsActive.getText();
        int counterActiveAfter = Integer.parseInt(strActiveAfter.replaceAll("[\\D]", ""));


        System.out.println("Number of clients before adding: " + counterActiveBefore);
        System.out.println("Number of clients after adding: " +counterActiveAfter);
        System.out.println("Text of Alert: " + strNotif);

    }

    public void addClientCheckSearchBar() throws IOException {

        sales.click();
        Random random = new Random();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));




        addClientButton.click();

        Faker faker = new Faker();

        String companyName = faker.company().name() + Date.from(Instant.now());
        String fullName = faker.superhero().name();
        String email = faker.commerce().promotionCode()+ "@test.com";
        String phoneNumber = faker.phoneNumber().cellPhone();
        String fullAddress = faker.address().fullAddress();

        Actions actionsTest = new Actions(driver);
        actionsTest.click(underAddClientTagSelect).pause(500).sendKeys(Keys.ENTER).perform();

        underAddClientCompanyNameField.sendKeys(companyName);
        underAddClientFullNameField.sendKeys(fullName);
        underAddClientEmailField.sendKeys(email);
        underAddClientPhoneNumberField.sendKeys(phoneNumber);
        underAddClientAddressField.sendKeys(fullAddress);
        underAddClientSaveButton.click();



        try{
            wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Client created successfully')]")));
        }catch(Throwable e){
            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
        }

        // create search bar implementation for tag/name/company etc see UI
        enterEmailTitleNameField.sendKeys(companyName);


        try {
            Thread.sleep(1000);

            WebElement companyColumn = driver.findElement(By.xpath("(//td)[3]"));

            wait.until(ExpectedConditions.visibilityOf(companyColumn));
            Thread.sleep(1800);
            System.out.println(companyColumn.getText());

            if (companyColumn.getText().equalsIgnoreCase(companyName)) {
                System.out.println("SUCCESS! Company name matches");

            }
            else System.out.println("FAIL");

        }
        catch (Throwable e){
            System.err.println("Search element not found for companyName " + e.getMessage());
        }
        enterEmailTitleNameField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

        enterEmailTitleNameField.sendKeys(fullName);


        try {
            Thread.sleep(1000);

            WebElement nameColumn = driver.findElement(By.xpath("(//td)[4]"));

            wait.until(ExpectedConditions.visibilityOf(nameColumn));
            Thread.sleep(1800);
            System.out.println(nameColumn.getText());

            if (nameColumn.getText().equalsIgnoreCase(fullName)) {
                System.out.println("SUCCESS! Full name matches");

            }
            else System.out.println("FAIL");

        }
        catch (Throwable e){
            System.err.println("Search element not found for FULLNAME " + e.getMessage());
        }
        enterEmailTitleNameField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

        enterEmailTitleNameField.sendKeys(email);


        try {
            Thread.sleep(1000);

            WebElement emailColumn = driver.findElement(By.xpath("(//td)[6]"));

            wait.until(ExpectedConditions.visibilityOf(emailColumn));
            Thread.sleep(1800);
            System.out.println(emailColumn.getText());

            if (emailColumn.getText().equalsIgnoreCase(email)) {
                System.out.println("SUCCESS! EMAIL matches");

            }
            else System.out.println("FAIL");

        }
        catch (Throwable e){
            System.err.println("Search element not found for EMAIL " + e.getMessage());
        }
        enterEmailTitleNameField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));




        UtilWait.takeScreenshot(driver,"src/test/java/screenshots/SearchBarTest.png");


    }

    public void archiveClients(){

        sales.click();
        archiveAllCheckbox.click();
        archiveButton.click();

    }

    public void addProduct(){

        productsAndServices.click();
        underProductsAndServicesAddProdORService.click();

    }




}
