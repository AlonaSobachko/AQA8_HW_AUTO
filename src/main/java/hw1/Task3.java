package hw1;
import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {
    public static void printElementInfo(WebElement element) {
        String id = element.getAttribute("id");
        if (id == null || id.isEmpty()) {
            id = "ID не заданий";
        }

        String tagName = element.getTagName();

        String className = element.getAttribute("class");
        if (className == null || className.isEmpty()) {
            className = "Клас не заданий";
        }

        String name = element.getAttribute("name");
        if (name == null || name.isEmpty()) {
            name = "Атрибут name не заданий";
        }

        String text = element.getText();
        if (text == null || text.isEmpty()) {
            text = "Текст не заданий";
        }

        Point location = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        int centerX = location.getX() + width / 2;
        int centerY = location.getY() + height / 2;

        System.out.println("ID елемента: " + id);
        System.out.println("Тег елемента: " + tagName);
        System.out.println("Клас елемента: " + className);
        System.out.println("Атрибут name елемента: " + name);
        System.out.println("Текст елемента: " + text);
        System.out.println("Координати центру елемента: (" + centerX + ", " + centerY + ")");
    }

    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        try {
            driver.get("https://all-face.com.ua/");
            Thread.sleep(5000);
            WebElement element = driver.findElement(By.id("account-modal"));
            printElementInfo(element);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
