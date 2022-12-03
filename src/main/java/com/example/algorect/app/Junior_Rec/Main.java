package com.example.algorect.app.Junior_Rec;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point topLeftRec1 = new Point(1,4);
        Point bottomRight1 = new Point(6, 1);
        Point topLeftRec2 = new Point(7,7);
        Point bottomRight2 = new Point(10,4);

//        Point topLeftRec1 = new Point(-5,5);
//        Point bottomRight1 = new Point(-1, 1);
//        Point topLeftRec2 = new Point(-7,8);
//        Point bottomRight2 = new Point(-3,5);

//      Second rectangle is smaller than first rectangle
//        Point topLeftRec2 = new Point(5,4);
//        Point bottomRight2 = new Point(7,2);

//      Second rectangle is greater than first rectangle
//        Point topLeftRec2 = new Point(5,6);
//        Point bottomRight2 = new Point(9,0);

//		CHECK TOP RIGHT
//		Point topLeftRec2 = new Point(5,9);
//		Point bottomRight2 = new Point(9,4);

//		CHECK BOTTOM RIGHT
//		Point topLeftRec2 = new Point(5,0);
//		Point bottomRight2 = new Point(9,-3);

        Rectangles rectangleOne = new Rectangles(topLeftRec1, bottomRight1);
        Rectangles rectangleTwo = new Rectangles(topLeftRec2, bottomRight2);

//		rectangleOne.containment(rectangleTwo);
//		rectangleOne.intersect(rectangleTwo);
        rectangleOne.adjacent(rectangleTwo);







//        int bottom1 = 1;
//        int top1 = 5;
//        int distancia1 = (int) getDistance(bottom1,top1);
//        System.out.println("Distancia: " + distancia1);
//        ArrayList<Integer> lista1 = new ArrayList<>();
//
//        for(int i = bottom1; i <= top1; i++){
//            lista1.add(i);
//        }
//
//        for(int i = 0; i <= distancia1; i++){
//            System.out.print(lista1.get(i));
//        }
//
//        int bottom2 = 0;
//        int top2 = 6;
//        int distancia2 = (int) getDistance(bottom2,top2);
//        System.out.println("Distancia: " + distancia2);
//        ArrayList<Integer> lista2 = new ArrayList<>();
//
//        for(int i = bottom2; i <= top2; i++){
//            lista2.add(i);
//        }
//
//        for(int i = 0; i <= distancia2; i++){
//            System.out.print(lista2.get(i));
//        }
//
//        System.out.println(" * ");
//
//        for(int i = 0; i <= distancia1; i++) { //Recorrer Array list del primer rectangulo
//            for(int j = 0; j <= distancia2; j++){ //Recorrer Array list del segundo rectangulo
//                if(lista1.get(i) == lista2.get(j)){
//                    System.out.println("True");
//                    break;
//                }else{
//                    System.out.println("false");
//                }
//            }
//            System.out.println(" - ");
//        }

    }
    static double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }
}
