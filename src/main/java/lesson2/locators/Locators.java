package lesson2.locators;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(1500);

        //By.id
        /*By locator = By.id("search");
        driver.findElement(locator);
        WebElement searchButton = driver.findElement(locator);
        searchButton.click();*/
        driver.findElement(By.id("search")).click();

        //By.name
        //ez-accept-all Username
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(5000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        }catch (NoSuchElementException e){
            System.out.println("No cookies button");
        }
        driver.findElement(By.name("Username")).sendKeys("Test");

        //By.tagName
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search-term")).sendKeys("handstand push ups in one minute");
        driver.findElement(By.id("search-button")).click();
        Thread.sleep(1000);
        String textFromElement = driver.findElement(By.tagName("h2")).getText();
        System.out.println(textFromElement);
        Thread.sleep(2000);

        //By.linkText partialLinkText
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("APPLICATION PROCESS")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.findElement(By.partialLinkText("DS SHOWCA")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }
}
