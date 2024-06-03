package hw3;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;


public class Task {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        try {
            // Крок 1: Відкрити пошук Google
            driver.get("https://www.google.com/search");

            // Крок 2: Ввести та відкрити посилання https://www.guinnessworldrecords.com/account/register? в новій вкладці
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("https://www.guinnessworldrecords.com/account/register?" + Keys.ENTER);
            Thread.sleep(2000);  // Зачекати, поки результати завантажаться
            WebElement firstResult = driver.findElement(By.cssSelector("h3"));
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).click(firstResult).keyUp(Keys.CONTROL).build().perform();
            Thread.sleep(2000);  // Зачекати, поки нова вкладка відкриється

            // Крок 3: Ввести та відкрити посилання https://www.hyrtutorials.com/p/alertsdemo.html в новій вкладці
            driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
            searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html" + Keys.ENTER);
            Thread.sleep(2000);  // Зачекати, поки результати завантажаться
            firstResult = driver.findElement(By.cssSelector("h3"));
            actions.keyDown(Keys.CONTROL).click(firstResult).keyUp(Keys.CONTROL).build().perform();
            Thread.sleep(2000);  // Зачекати, поки нова вкладка відкриється

            // Крок 4: Відкрити та заповнити форму на https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit
            driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
            searchBox.clear();
            searchBox.sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit" + Keys.ENTER);
            Thread.sleep(2000);  // Зачекати, поки результати завантажаться
            firstResult = driver.findElement(By.cssSelector("h3"));
            firstResult.click();
            Thread.sleep(2000);  // Зачекати, поки сторінка завантажиться

            // Переключитися на iframe
            driver.switchTo().frame("iframeResult");

            // Очистити та заповнити поля форми
            WebElement firstName = driver.findElement(By.name("fname"));
            WebElement lastName = driver.findElement(By.name("lname"));
            firstName.clear();
            firstName.sendKeys("Alona");
            lastName.clear();
            lastName.sendKeys("Sobachko");

            // Натиснути кнопку 'Submit'
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            submitButton.click();

            // Вивести текст з елемента Note
            WebElement note = driver.findElement(By.xpath("//div[@id='note']")); // Замінити на правильний шлях до елемента Note
            System.out.println("Note Text: " + note.getText());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Закрити браузер
            driver.quit();
        }
    }
}

