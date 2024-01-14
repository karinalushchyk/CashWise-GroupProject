package Tests;

import Pages.AizadaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;

public class AizadaReportsTests {
    static WebDriver driver;
    static AizadaPages reportsPage;
    @BeforeClass

    public static void getdriver() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("https://cashwise.us/dashboard/infographics");
       AizadaPages aizadaPages = new AizadaPages(driver);

        WebElement signIn = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        signIn.click();

        WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        email.sendKeys("admin555@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Codewiser123");

        WebElement signIn2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signIn2.click();
        Thread.sleep(8000);
    }

    @Test
    public void reportsPage() throws InterruptedException {

        reportsPage.reports.click();

        reportsPage.Transactions.click();
        reportsPage.addIncome.click();
        reportsPage.paymentDate.click();

        reportsPage.titleField.sendKeys("job");
        Thread.sleep(20000);
        reportsPage.categoryField.click();

        reportsPage.createNewCategory.click();
        reportsPage.title.sendKeys("Job");
        reportsPage.description.sendKeys("Job");
        reportsPage.saveButton.click();
        FluentWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        fluentWait.pollingEvery(Duration.ofSeconds(3))
                .ignoring(ElementClickInterceptedException.class)
                .until(ExpectedConditions.elementToBeClickable(reportsPage.category));


        reportsPage.category.click();
        reportsPage.jobField.click();
        reportsPage.sum.sendKeys("1200");
        reportsPage.acceptButton.click();

    }
}

