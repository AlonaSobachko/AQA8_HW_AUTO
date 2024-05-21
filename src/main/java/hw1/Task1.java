package hw1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

            String[] urls = {
                    "https://zoo.kiev.ua/",
                    "https://www.w3schools.com/",
                    "https://taxi838.ua/ru/dnepr/",
                    "https://klopotenko.com/"
            };

            driver.get(urls[0]);

            for (int i = 1; i < urls.length; i++) {
                ((ChromeDriver) driver).executeScript("window.open('');");
                ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(windows.get(windows.size() - 1));
                driver.get(urls[i]);
            }

            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            for (String window : windows) {
                driver.switchTo().window(window);
                String pageTitle = driver.getTitle();
                String currentUrl = driver.getCurrentUrl();
                System.out.println("Назва: " + pageTitle);
                System.out.println("Посилання: " + currentUrl);

                if (pageTitle.toLowerCase().contains("зоопарк")) {
                    driver.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(6000);
            driver.quit();
        }
    }
}
