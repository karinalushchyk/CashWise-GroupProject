package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.SalesPage;
import utilities.Driver;
import utilities.UtilWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class SalesTests {

    static WebDriver driver;
    static SalesPage salesPage;

    @BeforeClass
    public static void initialize(){
        driver = Driver.getDriver();
        salesPage = new SalesPage(driver);
        Driver.cashWiseSignIn();
        UtilWait.waitUntilElementIsClickable(driver,10,salesPage.sales);
        salesPage.sales.click();
    }



    @Test
    public void verifySalesURL() {

        Assert.assertTrue(driver.getCurrentUrl().contains("sales"));

    }

    @Test
    public void addProductPositive(){

        salesPage.productsAndServices.click();
        UtilWait.waitUntilElementIsClickable(driver,5,salesPage.underProductsAndServicesAddProdORService);
        salesPage.underProductsAndServicesAddProdORService.click();

        Random random = new Random();
        String name = UtilWait.generateString("AaBbCcDdZzHhEeIiYyUuMmOo",10);
        salesPage.underProductsAndServicesAddProdORServiceNameField
                .sendKeys(name);
        salesPage.underProductsAndServicesAddProdORServicePriceField
                .sendKeys(random.nextInt(1,5000) + "");

        salesPage.underProductsAndServicesAddProdORServiceSelectType.click();
        salesPage.underProductsAndServicesAddProdORServiceServiceTypeProduct.click();
        Actions actions1 = new Actions(driver);
        salesPage.underProductsAndServicesAddProdORServiceSelectCategory.click();
        actions1.sendKeys(Keys.ENTER).perform();

        salesPage.underProductsAndServicesSaveButton.click();



        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        try{
            wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(salesPage.underProductsAndServicesPopUpProd));
        }catch(Throwable e){
            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
        }

        Assert.assertEquals(salesPage.underProductsAndServicesPopUpProd.getText(),"Продукт successfully created");


    }

    @Test
    public void addServicePositive(){

        salesPage.productsAndServices.click();
        UtilWait.waitUntilElementIsClickable(driver,5,salesPage.underProductsAndServicesAddProdORService);
        salesPage.underProductsAndServicesAddProdORService.click();

        Random random = new Random();
        String name = UtilWait.generateString("AaBbCcDdZzHhEeIiYyUuMmOo",10);
        salesPage.underProductsAndServicesAddProdORServiceNameField
                .sendKeys(name);
        salesPage.underProductsAndServicesAddProdORServicePriceField
                .sendKeys(random.nextInt(1,5000) + "");

        salesPage.underProductsAndServicesAddProdORServiceSelectType.click();
        salesPage.underProductsAndServicesAddProdORServiceServiceTypeService.click();
        Actions actions1 = new Actions(driver);
        salesPage.underProductsAndServicesAddProdORServiceSelectCategory.click();
        actions1.sendKeys(Keys.ENTER).perform();

        salesPage.underProductsAndServicesSaveButton.click();



        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        try{
            wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(salesPage.underProductsAndServicesPopUpProd));
        }catch(Throwable e){
            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(salesPage.underProductsAndServicesPopUpService.getText(),"Сервис successfully created");


    }

    @Ignore
    public void importFromXLS() {

        salesPage.importFromXLSButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement inputFile = driver.findElement(By.xpath("//input[@placeholder='Select file in XLS format']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputFile));

        inputFile.sendKeys("\"C:\\Users\\erdni\\Downloads\\Sample.xls\"");
    }


    @Test
    public void verifyClientAdded() throws InterruptedException, IOException {

//        Random random = new Random();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//
//
//
//        String strActiveBefore = salesPage.clientsActive.getText();
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(salesPage.clientsActive, strActiveBefore))));
//        strActiveBefore = salesPage.clientsActive.getText();
//
//        int counterActiveBefore = Integer.parseInt(strActiveBefore.replaceAll("[\\D]", ""));
//
//        salesPage.addClientButton.click();
//
//        Actions actionsTest = new Actions(driver);
//        actionsTest.click(salesPage.underAddClientTagSelect).pause(500).sendKeys(Keys.ENTER).perform();
//
//        salesPage.underAddClientCompanyNameField.sendKeys("CompanyTest" + Date.from(Instant.now()));
//        salesPage.underAddClientFullNameField.sendKeys("Joe Doe");
//        salesPage.underAddClientEmailField.sendKeys("joe" + random.nextInt(1,1000) + "doe@test.com");
//        salesPage.underAddClientPhoneNumberField.sendKeys(random.nextInt(111111111,999999999) + "");
//        salesPage.underAddClientAddressField.sendKeys(random.nextInt(1,1234) + " Test St");
//        salesPage.underAddClientSaveButton.click();
//
//
//        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(salesPage.clientsActive, strActiveBefore)));
//
//        try{
//            wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Client created successfully')]")));
//        }catch(Throwable e){
//            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
//        }
//
//        UtilWait.takeScreenshot(driver,"src/test/java/screenshots/PictureTest.png");
//        String strNotif = salesPage.clientNotif.getText();
//
//        String strActiveAfter = salesPage.clientsActive.getText();
//        int counterActiveAfter = Integer.parseInt(strActiveAfter.replaceAll("[\\D]", ""));
//
//
//        System.out.println("Number of clients before adding: " + counterActiveBefore);
//        System.out.println("Number of clients after adding: " +counterActiveAfter);
//        System.out.println("Text of Alert: " + strNotif);

        salesPage.addClientWithExistingTag();
        driver.navigate().refresh();

    }

    @Test(dependsOnMethods = "verifyClientAdded")
    public void archieveAllClients(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        salesPage.archiveClients();
    }

    @Test
    public void verifyClientSearchBar() throws IOException {
        salesPage.addClientCheckSearchBar();
    }

    public void killSuit(){
        Driver.closeBrowser();
    }

}
