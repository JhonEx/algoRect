package com.example.algorect.app.Junior_Rec;

import java.util.ArrayList;
import java.util.List;

public class Rectangles {

    private Point bottomRight;
    private Point topLeft;

    public Rectangles(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean containment(Rectangles two) {
        if (this.topLeft.x < two.topLeft.x & this.bottomRight.x > two.bottomRight.x & this.topLeft.y > two.topLeft.y &
                this.bottomRight.y < two.bottomRight.y) {
            return true;
        }
        return false;
    }

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

	public boolean adjacent(Rectangles two) {

//       Coordenadas Y
        int dis_height_rec1 = (int) getDistance(this.bottomRight.y, this.topLeft.y);
        int dis_height_rec2 = (int) getDistance(two.bottomRight.y, two.topLeft.y);

        List<Integer> vectorY1 = new ArrayList<>();
        for(int i = this.bottomRight.y; i <= this.topLeft.y; i++){
            vectorY1.add(i);
        }

        List<Integer> vectorY2 = new ArrayList<>();
        for(int i = two.bottomRight.y; i <= two.topLeft.y; i++){
            vectorY2.add(i);
        }

//       Coordenadas X
        int dis_width_rec1 = (int) getDistance(this.bottomRight.x, this.topLeft.x);
        int dis_width_rec2 = (int) getDistance(two.bottomRight.x, two.topLeft.x);

        List<Integer> vectorX1 = new ArrayList<>();
        for(int i = this.topLeft.x; i <= this.bottomRight.x; i++){
            vectorX1.add(i);
        }

        List<Integer> vectorX2 = new ArrayList<>();
        for(int i = two.topLeft.x; i <= two.bottomRight.x; i++){
            vectorX2.add(i);
        }

        boolean check1 = compareVectors(vectorY1, vectorY2,dis_height_rec1,dis_height_rec2);
        boolean check2 = compareVectors(vectorX1, vectorX2,dis_width_rec1,dis_width_rec2);

//	CHECK						TOP											BOTTOM
		if(((this.topLeft.y == two.bottomRight.y && check2) || (this.bottomRight.y == two.topLeft.y && check2)) ||
//	CHECK						LEFT										RIGHT
			  ((this.topLeft.x == two.bottomRight.x && check1) || (this.bottomRight.x == two.topLeft.x && check1)))
        {
			return true;
		}
		return false;
	}

    static double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }

    static boolean compareVectors(List<Integer> arr1, List<Integer> arr2, int distancia1, int distancia2 ){
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
