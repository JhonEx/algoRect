package com.example.algorect.app.rectangleok;

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

        double X_1 = (this.topLeft.x + this.bottomRight.x) / 2 ;
        double X_2 = (two.bottomRight.x + two.topLeft.x) / 2;
        double Y_1 = (this.bottomRight.y + this.topLeft.y)/ 2 ;
        double Y_2 = (two.bottomRight.y + two.topLeft.y) / 2;

        double width_1 = getDistance(this.bottomRight.x, this.topLeft.x);
        double width_2 = getDistance(two.bottomRight.x, two.topLeft.x);
        double height_1 = getDistance(this.bottomRight.y, this.topLeft.y);
        double height_2 = getDistance(two.bottomRight.y, two.topLeft.y);

        double width_rec1 = X_1 + width_1 / 2;
        double width_rec2 = X_2 - width_2;
        double height_rec1 = Y_1 + height_1 / 2;
        double height_rec2 = Y_2 - height_2;
        double distanceY = getDistance(Y_1, Y_2);
        double heightD =  height_1 / 2 + height_2/ 2;
        double distanceX = getDistance(X_1, X_2);
        double widthD =  width_1 / 2 + height_2 / 2;

        if (!(containment(two)) && !(adjacency(two)) && (width_rec1 > width_rec2 || height_rec1 > height_rec2)
                && distanceY < heightD && distanceX < widthD ) {
            return true;
        }
        return false;
    }

	public boolean adjacency(Rectangles two) {

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
