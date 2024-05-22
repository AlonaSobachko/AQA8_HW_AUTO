package hw2;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
            Select selectBox = new Select(driver.findElement(By.id("Carlist")));
            selectBox.selectByValue("Renault Car");
            Thread.sleep(2000);
            Select countryList = new Select(driver.findElement(By.name("FromLB")));
            countryList.selectByVisibleText("France");
            Thread.sleep(2000);
            countryList.selectByVisibleText("India");
            Thread.sleep(2000);
            countryList.deselectByVisibleText("India");
            Thread.sleep(2000);
            countryList.selectByVisibleText("Germany");
            Thread.sleep(2000);
            countryList.selectByVisibleText("Italy");
            Thread.sleep(2000);
            countryList.selectByVisibleText("Malaysia");
            Thread.sleep(2000);
            countryList.deselectByVisibleText("Malaysia");
            Thread.sleep(2000);
            countryList.selectByVisibleText("Spain");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='->']")).click();
            Thread.sleep(5000);
            List<WebElement> carOptions = selectBox.getOptions();
            System.out.print("Автомобілі доступні для вибору:\n");
            for (WebElement carOption : carOptions) {
                System.out.print(carOption.getText() + ", ");
            }
            List<WebElement> firstTableCountries = driver.findElements(By.name("FromLB"));
            System.out.print("\n\nКраїни з першої таблиці:\n");
            for (WebElement country : firstTableCountries) {
                System.out.print(country.getText() + ", ");
            }
            List<WebElement> secondTableCountries = driver.findElements(By.name("ToLB"));
            System.out.print("\n\nКраїни з другої таблиці:\n");
            for (WebElement country : secondTableCountries) {
                System.out.print(country.getText() + ", ");
            }
        } finally {
            driver.quit();
        }
    }
}
