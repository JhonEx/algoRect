package com.example.algorect.app;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void initial(){

        Rectangle r1 = new Rectangle(2, 2, 5.5, 4.9);

        System.out.println("\nRectangle:");
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        System.out.println((r1.contains(3, 3) ? "Contains" : "Does not contain") +
                " the point (3, 3).");
        System.out.println((r1.contains(new Rectangle(4, 5, 10.5, 3.2)) ? "Contains" :
                "Does not contain") + " the rectangle with points (4, 5, 10.5, 3.2)");

        System.out.println((r1.overlaps(new Rectangle(3, 5, 2.3, 5.4)) ? "Overlaps" :
                "Does not overlap") + " the rectangle with points (3, 5, 2.3, 5.4)");
    }

    @Test
    public void testArea(){
        Rectangle r1 = new Rectangle(2, 2, 5, 4);
        assertEquals(20, r1.getArea());
    }
}