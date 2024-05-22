package hw2;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        WebElement amount5000 = driver.findElement(By.id("fourth"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement debitSideAmount = driver.findElement(By.id("amt7"));
        WebElement creditSideAmount = driver.findElement(By.id("amt8"));
        WebElement debitSideAccount = driver.findElement(By.id("bank"));
        WebElement creditSideAccount = driver.findElement(By.id("loan"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(amount5000, debitSideAmount).perform();
        Thread.sleep(2000);
        builder.dragAndDrop(amount5000, creditSideAmount).perform();
        Thread.sleep(2000);
        builder.dragAndDrop(bank, debitSideAccount).perform();
        Thread.sleep(2000);
        builder.dragAndDrop(sales, creditSideAccount).perform();
        Thread.sleep(5000);
        WebElement perfectButton = driver.findElement(By.id("equal"));
        System.out.println(perfectButton.getText());
        driver.quit();
    }
}
