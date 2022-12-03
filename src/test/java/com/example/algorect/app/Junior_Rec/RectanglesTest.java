package com.example.algorect.app.Junior_Rec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectanglesTest {
    Point topLeftRec1;
    Point bottomRight1;

    @BeforeEach
    void setUp() {

    }

    @Test
    void containment() {
        topLeftRec1 = new Point(1,10);
        bottomRight1 = new Point(8, 1);
        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);

        assertTrue(rectangleOne.containment(new Rectangles(new Point(2,4), new Point(5,2))));
        assertFalse(rectangleOne.containment(new Rectangles(new Point(6,7), new Point(10,4))));
    }

    @Test
    void intersect() {

    }

    @Test
    void adjacent() {
        topLeftRec1 = new Point(1,4);
        bottomRight1 = new Point(6, 1);
        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);

        assertTrue(rectangleOne.adjacent(new Rectangles(new Point(6,7), new Point(10,4))));
        assertFalse(rectangleOne.adjacent(new Rectangles(new Point(7, 7), new Point(10, 4))));
    }
}