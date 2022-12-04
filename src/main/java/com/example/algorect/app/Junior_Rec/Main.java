package com.example.algorect.app.Junior_Rec;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
////        EXAMPLE CONTAINMENT
//        Point topLeftRec1 = new Point(1,5);
//        Point bottomRight1 = new Point(5, 1);
//        Point topLeftRec2 = new Point(2,4);
//        Point bottomRight2 = new Point(4,2);

//      EXAMPLE INTERSECT/OVERLAPS
        Point topLeftRec1 = new Point(1,4);
        Point bottomRight1 = new Point(6, 1);
        Point topLeftRec2 = new Point(5,7);
        Point bottomRight2 = new Point(10,3);

        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);
        Rectangles rectangleTwo = new Rectangles(topLeftRec2, bottomRight2);

		rectangleOne.containment(rectangleTwo);
		rectangleOne.intersect(rectangleTwo);
        rectangleOne.adjacent(rectangleTwo);

    }
}
