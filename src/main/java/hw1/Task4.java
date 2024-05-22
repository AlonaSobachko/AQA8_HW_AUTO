package hw1;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Task4 {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get("http://www.automationpractice.pl/index.php");
            WebElement searchBox = driver.findElement(By.id("search_query_top"));
            searchBox.sendKeys("Printed Chiffon Dress");
            WebElement searchButton = driver.findElement(By.name("submit_search"));
            searchButton.click();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='product_img_link' and @title='Printed Chiffon Dress']")));
            firstProduct.click();
            boolean isProductAvailable = isElementPresent(driver, By.xpath("//span[@class='available-now']"));
            if (isProductAvailable) {
                WebElement addToCartButton = driver.findElement(By.name("Submit"));
                addToCartButton.click();
                WebElement continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Continue shopping']")));
                continueShoppingButton.click();
            } else {
                System.out.println("Товар не доступний до замовлення");
                Thread.sleep(5000);
            }
            WebElement womenTab = driver.findElement(By.xpath("//a[@title='Women']"));
            womenTab.click();
            WebElement womenSearchBox = driver.findElement(By.id("search_query_top"));
            womenSearchBox.sendKeys("Faded Short");
            WebElement womenSearchButton = driver.findElement(By.name("submit_search"));
            womenSearchButton.click();
            WebElement womenFirstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='product_img_link' and @title='Faded Short Sleeve T-shirts']")));
            womenFirstProduct.click();
            boolean isWomenProductAvailable = isElementPresent(driver, By.xpath("//span[@class='available-now']"));
            if (isWomenProductAvailable) {
                WebElement womenAddToCartButton = driver.findElement(By.name("Submit"));
                womenAddToCartButton.click();
                WebElement womenContinueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Continue shopping']")));
                womenContinueShoppingButton.click();
            } else {
                System.out.println("Товар не доступний до замовлення");
                Thread.sleep(5000);
            }
            WebElement cartButton = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
            cartButton.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
