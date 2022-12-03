package com.example.algorect.app.Junior_Rec;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point topLeftRec1 = new Point(1,5);
        Point bottomRight1 = new Point(5, 1);
        Point topLeftRec2 = new Point(1,5);
        Point bottomRight2 = new Point(5,0);

        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);
        Rectangles rectangleTwo = new Rectangles(topLeftRec2, bottomRight2);

		rectangleOne.containment(rectangleTwo);
		rectangleOne.intersect(rectangleTwo);
        rectangleOne.adjacent(rectangleTwo);

    }
}
