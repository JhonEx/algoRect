package com.example.algorect.app.rectangleok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectanglesTest {
    Point topLeftRec1;
    Point bottomRight1;

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
        topLeftRec1 = new Point(1,5);
        bottomRight1 = new Point(5, 1);
        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);

        //check intersection in axe y.
        assertTrue(rectangleOne.intersect(new Rectangles(new Point(3,4), new Point(8,2))));
        assertFalse(rectangleOne.intersect(new Rectangles(new Point(6,4), new Point(8,2))));

        //check intersection in axe x.
        assertTrue(rectangleOne.intersect(new Rectangles(new Point(2,7), new Point(4,4))));
        assertFalse(rectangleOne.intersect(new Rectangles(new Point(2,7), new Point(4,6))));

        //check intersection in axe x, y.
        assertTrue(rectangleOne.intersect(new Rectangles(new Point(3,9), new Point(7,3))));
        assertFalse(rectangleOne.intersect(new Rectangles(new Point(2,7), new Point(7,6))));

        //check intersection in axe x, y with negatives
        assertTrue(rectangleOne.intersect(new Rectangles(new Point(-1,8), new Point(3,-1))));

    }

    @Test
    void adjacent() {
        topLeftRec1 = new Point(1,4);
        bottomRight1 = new Point(6, 1);
        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);

        assertTrue(rectangleOne.adjacency(new Rectangles(new Point(6,7), new Point(10,4))));
        assertFalse(rectangleOne.adjacency(new Rectangles(new Point(7, 7), new Point(10, 4))));
    }
}