package hw4;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task5 {
    WebDriver driver = DriverInit.setUpDriver();
    @Parameters("searchWord")
    @Test
    public void testFoxtrotSearch(String searchWord) throws InterruptedException {
        driver.get("https://www.foxtrot.com.ua/");
        try {
            WebElement popupCloseButton = driver.findElement(By.xpath("//*[@id=\"user-location-popup\"]/div/div[1]/i"));
            popupCloseButton.click();
        } catch (Exception e) {

        }
        Thread.sleep(2000);
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]/div/div/div[3]/input[1]"));
        searchInput.sendKeys(searchWord);
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]/div/div/div[3]/input[2]"));
        searchButton.click();
        Thread.sleep(2000);
        searchInput.clear();

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
