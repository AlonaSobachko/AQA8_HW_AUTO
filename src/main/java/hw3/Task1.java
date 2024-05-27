package hw3;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://www.google.com/search");
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement guinnessLink = driver.findElement(By.partialLinkText("Guinness World Records"));
        String guinnessLinkUrl = guinnessLink.getAttribute("href");
        ((ChromeDriver) driver).executeScript("window.open('" + guinnessLinkUrl + "','_blank');");
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Thread.sleep(2000);
        searchBox = driver.findElement(By.name("q"));
        searchBox.clear(); // Очистимо поле перед введенням нового запиту
        searchBox.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchBox.sendKeys(Keys.ENTER); // Використовуємо клавішу ENTER замість submit()
        WebElement hyrTutorialsLink = driver.findElement(By.partialLinkText("AlertsDemo"));
        String hyrTutorialsLinkUrl = hyrTutorialsLink.getAttribute("href");
        ((ChromeDriver) driver).executeScript("window.open('" + hyrTutorialsLinkUrl + "','_blank');");
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Thread.sleep(2000);
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        driver.switchTo().frame("iframeResult");
        WebElement firstNameField = driver.findElement(By.id("fname"));
        WebElement lastNameField = driver.findElement(By.id("lname"));
        firstNameField.sendKeys("Alona");
        lastNameField.sendKeys("Sobachko");
        Thread.sleep(2000);
        // Натиснути кнопку 'Submit'
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/input[3]"));
        submitButton.click();
    }
}
