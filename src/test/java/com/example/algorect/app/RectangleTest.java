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

        Rectangle r1 = new Rectangle(3, 3, 6, 6);

        System.out.println("\nRectangle:");
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        System.out.println((r1.contains(3, 3) ? "Contains x y " : "Does not contain"));

        System.out.println((r1.contains(new Rectangle(3, 3, 2, 2)) ? "Contains" : "Does not contain"));

        System.out.println((r1.overlaps(new Rectangle(7, 7, 3, 5)) ? "Overlaps" : "Does not overlap"));
    }

    @Test
    public void testArea(){
        Rectangle r1 = new Rectangle(2, 2, 5, 4);
        assertEquals(20, r1.getArea());
    }
}