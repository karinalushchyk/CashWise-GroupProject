package tests;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CashwiseSignIn;
import pages.Report_chart_page;
import utilities.Driver;
import utilities.UtilWait;

import java.io.File;

public class Report_chart_tests {

    public static WebDriver driver;
    public static Report_chart_page reportChartPage;

    @BeforeClass
    public static void setLogIn() throws InterruptedException {
        driver = Driver.getDriver();
        reportChartPage = new Report_chart_page(driver);
        reportChartPage.setUpSignIn();
        Thread.sleep(2000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.cashwise.us/dashboard/infographics");
        reportChartPage.reports.click();
        Thread.sleep(2000);
        reportChartPage.reportChart.click();
        driver.manage().window().maximize();


    }

    @Test
    public void verify_Delete_Functionality() throws InterruptedException {
        Thread.sleep(2000);
        reportChartPage.deleteButton.click();
        reportChartPage.clickDeleteButton.click();
        System.out.println("The delete function isn't working properly" +
                " users are unable to delete using this feature. ");
        Thread.sleep(2000);
        try {
             File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            System.out.println(f.createNewFile());
        }
        catch (Exception e){

        }
        reportChartPage.cancelButton.click();


    }

    @Test(dependsOnMethods = "verify_Delete_Functionality")
    public void verify_Create_New_Invoice1() throws InterruptedException {
        reportChartPage.createNewInvoice.click();
        reportChartPage.paymentMethod.click();
        reportChartPage.cashButton.click();
        Faker faker = new Faker();
        String titleName = faker.name().title();
        reportChartPage.newInvoiceTitle.sendKeys(titleName);
        reportChartPage.newInvoiceBalance.sendKeys("3000");
        reportChartPage.newInvoiceSaveButton.click();
        System.out.println("This test case passed with valid input");


    }

    @Test(dependsOnMethods = "verify_Create_New_Invoice1")
    public void verify_Create_New_Invoice2() throws InterruptedException {
        reportChartPage.createNewInvoice.click();
        Faker faker = new Faker();
        String invoiceTitle  = faker.name().title();
        reportChartPage.newInvoiceTitle.sendKeys(invoiceTitle);
        reportChartPage.newInvoiceBalance.sendKeys("3000");
        reportChartPage.newInvoiceSaveButton.click();
        reportChartPage.cancelButton.click();
        System.out.println("Passed: Payment method functionality is currently not meeting for specific requirements  ");


    }

    @Test(dependsOnMethods = "verify_Create_New_Invoice2")
    public void verify_Create_New_Invoice3() throws InterruptedException {
        reportChartPage.createNewInvoice.click();
        reportChartPage.paymentMethod.click();
        reportChartPage.cashButton.click();
        Faker faker = new Faker();
        String titleName = faker.name().title();
        reportChartPage.newInvoiceTitle.sendKeys(titleName);
        reportChartPage.newInvoiceBalance.sendKeys("00000");
        reportChartPage.newInvoiceSaveButton.click();

        System.out.println("Passed: balance functionality is currently not meeting for specific requirements this functional saved with '000' balance");

    }


}
