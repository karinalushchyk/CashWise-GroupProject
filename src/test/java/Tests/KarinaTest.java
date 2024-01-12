package Tests;

import Pages.ElzaNewAdmin;
import Pages.KarinaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.UtilWait;

import java.util.concurrent.TimeUnit;

public class KarinaTest {

    public static WebDriver driver;
    static KarinaPage karinaPage;

    @BeforeClass
    public static void runBeforeClass() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("https://cashwise.us/dashboard/infographics");
        karinaPage = new KarinaPage(driver);

        karinaPage.signInBtn.click();
        karinaPage.logInEmail.sendKeys("admin555@gmail.com");
        karinaPage.logInPassword.sendKeys("Codewiser123");
        karinaPage.confirmSignInBtn.click();
        Thread.sleep(7000);
        karinaPage.salesButton.click();
        karinaPage.invoiceButton.click();
    }

    @Test
    public void InvoicePage() throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        karinaPage.salesButton.click();
        karinaPage.invoiceButton.click();

        karinaPage.createInvoiceButton.click();

        String expectedUrl = "https://cashwise.us/dashboard/sales/invoice/create";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Current URL is correct ");
        } else
            System.out.println("Current URL is incorrect");

        karinaPage.invoiceName.sendKeys("James Jo");

        WebElement whomButton = driver.findElement(By.xpath("//div[@class=' css-1jkhjy1-control']"));

        Actions actionsTest = new Actions(driver);
        actionsTest.click(karinaPage.whomButton).pause(500).sendKeys(Keys.ENTER).perform();


        karinaPage.payUntil.click();
        Actions actions = new Actions(driver);
        actions.sendKeys("12/02/2024").perform();

        karinaPage.description.click();
        Actions actionsDescription = new Actions(driver);
        actions.sendKeys("Invoice").perform();

        karinaPage.selectProductButton.click();

        karinaPage.pickTitle.click();

        if (karinaPage.totalSum.isDisplayed() && karinaPage.sumOfDiscount.isDisplayed() && karinaPage.total.isDisplayed()) {
            System.out.println("Text are present on the page");
        } else {
            System.out.println("Texts are not present");
        }

        karinaPage.saveButton.click();
    }

    @Test
    public void acceptPayment() throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        Thread.sleep(3000);

        karinaPage.acceptPayment.click();


        WebElement selectPaymentMethod = driver.findElement(By.id("mui-component-select-type_of_pay"));
        karinaPage.selectPaymentMethod.click();

        karinaPage.cash.click();

        karinaPage.toWhichCheck.click();

        karinaPage.jj.click();

        karinaPage.comment.sendKeys("Payment");

        karinaPage.saveButton2.click();



    }
    @Test
    public void deletePaidInvoices() throws InterruptedException {
        karinaPage.status.click();
        karinaPage.NotPaidStatus.click();
        Thread.sleep(3000);
        karinaPage.selectBox1.click();
        karinaPage.deleteSelected.click();

    }
}
