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
            // Відкриваємо веб-сторінку
            driver.get("http://www.automationpractice.pl/index.php");

            // Знаходимо поле пошуку і вводимо текст "Printed Chiffon Dress"
            WebElement searchBox = driver.findElement(By.id("search_query_top"));
            searchBox.sendKeys("Printed Chiffon Dress");

            // Знаходимо кнопку пошуку і натискаємо її
            WebElement searchButton = driver.findElement(By.name("submit_search"));
            searchButton.click();

            // Чекаємо, поки результати пошуку завантажаться
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-name' and @title='Printed Chiffon Dress']")));

            // Знаходимо і натискаємо на потрібний товар
            WebElement productLink = driver.findElement(By.xpath("//a[@class='product-name' and @title='Printed Chiffon Dress']"));
            productLink.click();

            // Чекаємо завантаження сторінки товару
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart")));

            // Переходимо на вкладку WOMEN
            WebElement womenTab = driver.findElement(By.xpath("//a[@title='Women']"));
            womenTab.click();

            // Чекаємо завантаження сторінки WOMEN
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));

            // Знаходимо поле пошуку і вводимо текст "Faded Short"
            searchBox = driver.findElement(By.id("search_query_top"));
            searchBox.clear(); // Очищаємо поле пошуку перед новим введенням
            searchBox.sendKeys("Faded Short");

            // Знаходимо кнопку пошуку і натискаємо її
            searchButton = driver.findElement(By.name("submit_search"));
            searchButton.click();

            // Чекаємо, поки результати пошуку завантажаться
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']")));

            // Знаходимо і натискаємо на потрібний товар
            WebElement fadedShortLink = driver.findElement(By.xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']"));
            fadedShortLink.click();

            // Чекаємо завантаження сторінки товару
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart")));

            // Чекаємо деякий час (необов'язково, для демонстрації)
            Thread.sleep(3000);

            // Переходимо до кошика
            WebElement cartButton = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
            cartButton.click();

            // Чекаємо завантаження сторінки кошика
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_title")));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закриваємо драйвер
            driver.quit();
        }
    }
}
