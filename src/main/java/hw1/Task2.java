package hw1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void analyzeElements(WebElement element1, WebElement element2) {
        Point location1 = element1.getLocation();
        Point location2 = element2.getLocation();

        String higherElement = (location1.getY() < location2.getY()) ? "Елемент 1" : "Елемент 2";
        String leftElement = (location1.getX() < location2.getX()) ? "Елемент 1" : "Елемент 2";

        Dimension size1 = element1.getSize();
        Dimension size2 = element2.getSize();

        String largerElement = (size1.getHeight() * size1.getWidth() > size2.getHeight() * size2.getWidth()) ? "Елемент 1" : "Елемент 2";

        System.out.println("Елемент, який розташовується вище на сторінці: " + higherElement);
        System.out.println("Елемент, який розташовується ліворуч на сторінці: " + leftElement);
        System.out.println("Елемент з більшою площею: " + largerElement);
    }
}
