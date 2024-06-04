package hw4.priority;
import org.junit.jupiter.api.*;
import java.lang.reflect.Method;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(CustomOrderer.class)
public class Priority1_2 {
    //Спосіб 2
    @Test
    @Order(1)
    public void a() {
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void b() {
        assertTrue(true);
    }

    @Test
    @Order(3)
    public void c() {
        assertTrue(true);
    }

    @Test
    @Order(4)
    public void d() {
        assertTrue(true);
    }

    @Test
    @Order(5)
    public void e() {
        assertTrue(true);
    }

    @Test
    @Order(6)
    public void f() {
        assertTrue(true);
    }

    @Test
    @Order(7)
    public void g() {
        assertTrue(true);
    }
}

class CustomOrderer implements MethodOrderer {
    @Override
    public void orderMethods(MethodOrdererContext context) {
        context.getMethodDescriptors().sort(Comparator.comparing(
                method -> method.getMethod().getName(), Comparator.reverseOrder()));
    }
}
