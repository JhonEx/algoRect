package com.example.algorect.app.Junior_Rec;

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

    // Detecting if one rectangle is adjacent to another
//	public boolean adjacent(rectangles two) {
////	CHECK						TOP											BOTTOM
//		if(	  (this.topLeft.y == two.bottomRight.y || this.bottomRight.y == two.topLeft.y) ||
////	CHECK						LEFT										RIGHT
//			  (this.topLeft.x == two.bottomRight.x || this.bottomRight.x == two.topLeft.x)  //if on left or right of rectangle
////		   && this.topLeft.y <= two.topLeft.y //if same size or less than of rectangle
////		   && this.bottomRight.y >= two.bottomRight.y
//	      ) {
//			System.out.println("They are adjacent");
//			return true;
//		}
//		System.out.println("They are not adjacent");
//		return false;
//	}



    public boolean adjacent(Rectangles two) {
//	CHECK						TOP											BOTTOM
        if(	  (this.topLeft.y == two.bottomRight.y || this.bottomRight.y == two.topLeft.y) ||
//	CHECK						LEFT										RIGHT
                (this.topLeft.x == two.bottomRight.x || (this.bottomRight.x == two.topLeft.x && ((this.topLeft.y >= two.topLeft.y && this.bottomRight.y <= two.topLeft.y ) || this.bottomRight.y <= two.bottomRight.y )))  //if on left or right of rectangle
//		   && this.topLeft.y <= two.topLeft.y //if same size or less than of rectangle
//		   && this.bottomRight.y >= two.bottomRight.y
        ) {
            System.out.println("They are adjacent");
            return true;
        }
        System.out.println("They are not adjacent");
        return false;
    }



}
