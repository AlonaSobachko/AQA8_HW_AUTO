package hw3;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.google.com/search");
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBox.sendKeys("https://www.guinnessworldrecords.com/account/register?");
            searchBox.submit();
            WebElement firstLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/h3")));
            String firstLinkUrl = firstLink.findElement(By.xpath("..")).getAttribute("href");
            ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", firstLinkUrl);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(1));
            driver.switchTo().window(windows.get(0));
            searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBox.clear();
            searchBox.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
            searchBox.submit();
            firstLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/h3")));
            firstLinkUrl = firstLink.findElement(By.xpath("..")).getAttribute("href");
            ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", firstLinkUrl);
            wait.until(ExpectedConditions.numberOfWindowsToBe(3));
            windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(2));
            driver.switchTo().window(windows.get(0));
            searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBox.clear();
            searchBox.sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
            searchBox.submit();
            firstLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/h3")));
            firstLinkUrl = firstLink.findElement(By.xpath("..")).getAttribute("href");
            driver.get(firstLinkUrl);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fname")));
            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lname")));
            firstName.clear();
            firstName.sendKeys("Alona");
            lastName.clear();
            lastName.sendKeys("Sobachko");
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
            Thread.sleep(3000);
            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().contains("guinnessworldrecords.com/account/register")) {
                    break;
                }
            }
            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EmailAddress")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
            WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ConfirmPassword")));
            firstNameField.clear();
            firstNameField.sendKeys("Alona");
            lastNameField.clear();
            lastNameField.sendKeys("Sobachko");
            emailField.clear();
            emailField.sendKeys("lnk@mail.com");
            passwordField.clear();
            passwordField.sendKeys("YourPassword123");
            confirmPasswordField.clear();
            confirmPasswordField.sendKeys("YourPassword");
            Thread.sleep(3000);
            WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/form/div[2]/button"));
            registerButton.click();
            for (String window : allWindows) {
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().equals("https://www.hyrtutorials.com/p/alertsdemo.html")) {
                    break;
                }
            }
            WebElement firstButton = driver.findElement(By.id("alertBox"));
            firstButton.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(3000);;
            driver.switchTo().alert().accept();
            WebElement secondButton = driver.findElement(By.id("confirmBox"));
            secondButton.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(3000);
            driver.switchTo().alert().dismiss();
            WebElement thirdButton = driver.findElement(By.id("promptBox"));
            thirdButton.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("Final step of this task");
            alert.accept();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}