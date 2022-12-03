package com.example.algorect.app.Junior_Rec;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Rectangles {

    // defining 2 main points of a rectangle - bottomRight & topLeft
    private Point bottomRight;
    private Point topLeft;

    public Rectangles(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    // Detecting if one rectangle contains another
    public boolean containment(Rectangles two) {
        if (this.topLeft.x < two.topLeft.x &
                this.bottomRight.x > two.bottomRight.x &
                this.topLeft.y < two.topLeft.y &
                this.bottomRight.y > two.bottomRight.y) {
            System.out.println("They are contained");
            return true;
        }
        System.out.println("They are not contained");
        return false;
    }

    // Detecting intersecting rectangles
    // Containment counts as an intersection
    public boolean intersect(Rectangles two) {
        if (this.topLeft.y < two.bottomRight.y ||
                this.bottomRight.y > two.topLeft.y ||
                this.bottomRight.x < two.topLeft.x ||
                this.topLeft.x > two.bottomRight.x) {
            System.out.println("They are intersecting");
            return true;
        }
        System.out.println("They are not intersecting");
        return false;
    }

////     Detecting if one rectangle is adjacent to another
	public boolean adjacent(Rectangles two) {

//       Coordenadas Y
        int dis_height_rec1 = (int) getDistance(this.bottomRight.y, this.topLeft.y);
        System.out.println("Distancia y_1: " + dis_height_rec1);
        int dis_height_rec2 = (int) getDistance(two.bottomRight.y, two.topLeft.y);
        System.out.println("Distancia y_2: " + dis_height_rec2);

        ArrayList<Integer> vectorY1 = new ArrayList<>();
        for(int i = this.bottomRight.y; i <= this.topLeft.y; i++){
            vectorY1.add(i);
        }
        ArrayList<Integer> vectorY2 = new ArrayList<>();
        for(int i = two.bottomRight.y; i <= two.topLeft.y; i++){
            vectorY2.add(i);
        }

//       Coordenadas X
        int dis_width_rec1 = (int) getDistance(this.bottomRight.x, this.topLeft.x);
        System.out.println("Distancia x_1: " + dis_width_rec1);
        int dis_width_rec2 = (int) getDistance(two.bottomRight.x, two.topLeft.x);
        System.out.println("Distancia x_2: " + dis_width_rec2);

        ArrayList<Integer> vectorX1 = new ArrayList<>();
        for(int i = this.topLeft.x; i <= this.bottomRight.x; i++){
            vectorX1.add(i);
        }
        for(int i = 0; i <= dis_width_rec1; i++){
            System.out.print(vectorX1.get(i));
        }
        System.out.println(" ");
        ArrayList<Integer> vectorX2 = new ArrayList<>();
        for(int i = two.topLeft.x; i <= two.bottomRight.x; i++){
            vectorX2.add(i);
        }
        for(int i = 0; i <= dis_width_rec2; i++){
            System.out.print(vectorX2.get(i));
        }

        boolean check1 = check(vectorY1, vectorY2,dis_height_rec1,dis_height_rec2);
        boolean check2 = check(vectorX1, vectorX2,dis_width_rec1,dis_width_rec2);

//	CHECK						TOP											BOTTOM
		if(	  ((this.topLeft.y == two.bottomRight.y && check2) || (this.bottomRight.y == two.topLeft.y && check2)) ||
//	CHECK						LEFT										RIGHT
			  ((this.topLeft.x == two.bottomRight.x && check1) || (this.bottomRight.x == two.topLeft.x && check1))

	      ) {
			System.out.println("They are adjacent");
			return true;
		}
		System.out.println("They are not adjacent");
		return false;
	}

    static double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }

    static boolean check(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int distancia1, int distancia2 ){
        for(int i = 0; i <= distancia1; i++) { //Recorrer Array list del primer rectangulo
            for(int j = 0; j <= distancia2; j++){ //Recorrer Array list del segundo rectangulo
                if(arr1.get(i) == arr2.get(j)){
                    return true;
                }
            }
        }
        return false;
    }

}
