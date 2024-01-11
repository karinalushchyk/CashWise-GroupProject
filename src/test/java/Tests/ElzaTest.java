package Tests;

import Pages.ElzaNewAdmin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

public class ElzaTest {
    public static WebDriver driver;
    static ElzaNewAdmin elzaNewAdmin;

    @BeforeClass
    public static void runBeforeClass() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("https://cashwise.us/dashboard/infographics");

        elzaNewAdmin = new ElzaNewAdmin(driver);

        elzaNewAdmin.signInBtn.click();
        elzaNewAdmin.logInEmail.sendKeys("admin555@gmail.com");
        elzaNewAdmin.logInPassword.sendKeys("Codewiser123");
        elzaNewAdmin.confirmSignInBtn.click();
        Thread.sleep(7000);

    }

    @Test
    public void createNewAdminAccount() throws InterruptedException {
          elzaNewAdmin.adminCodewiseBtn.click();
          elzaNewAdmin.createAccount.click();
          elzaNewAdmin.name.sendKeys("student");
          elzaNewAdmin.lastName.sendKeys("groupProject");
          elzaNewAdmin.email.click();
          Actions actions = new Actions(driver);
          actions.keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();

          elzaNewAdmin.email.sendKeys("hello400@gmail.com");
          elzaNewAdmin.phoneNum.sendKeys("111111111");

          elzaNewAdmin.password.click();
          Actions actions2 = new Actions(driver);
          actions2.keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();

          elzaNewAdmin.password.sendKeys("0987654321");
          elzaNewAdmin.repeatPassword.sendKeys("0987654321");

          elzaNewAdmin.cashier.click();
          elzaNewAdmin.createBtn.click();

          Thread.sleep(4000);

          elzaNewAdmin.adminCodewiseBtn.click();
          elzaNewAdmin.logOut.click();
          elzaNewAdmin.confirmLogOut.click();

          elzaNewAdmin.signInBtn.click();
          Actions actions3 = new Actions(driver);
          actions3.keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();

          elzaNewAdmin.logInEmail.sendKeys("hello400@gmail.com");
          elzaNewAdmin.logInPassword.sendKeys("0987654321");
          elzaNewAdmin.confirmSignInBtn.click();
    }
}
