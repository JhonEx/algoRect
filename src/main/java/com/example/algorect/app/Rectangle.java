package com.example.algorect.app;

// Implement MyRectangle2D class
public class Rectangle {
    // Data fields
    private double x;
    private double y;
    private double width;
    private double height;

    // Constructors
    /** Creates a default rectangle with (0, 0)
     *   for (x, y) and 1 for both width and height */
    Rectangle() {
        this(0, 0, 1, 1);
    }

    Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Methods
    /** Set x to specified point */
    public void setX(double x) {
        this.x = x;
    }

    /** Set y to specified point */
    public void setY(double y) {
        this.x = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return getDistance(this.y, y) <= height / 2 && getDistance(this.x, x) <= width / 2;
    }

    /** Returns true if the specified
     *   rectangle is inside this rectangle */
    public boolean contains(Rectangle r) {
        double distanceY = getDistance(y, r.getY()) + r.getHeight() / 2;
        double distanceX = getDistance(x, r.getX()) + r.getWidth() / 2 ;
        double heightR = height / 2 + r.getHeight() / 2;
        double widthR = width / 2 + r.getWidth() / 2;

        if(distanceY <= height / 2 && distanceX <= width / 2  && heightR <= height &&  widthR  <= width){
            return true;
        }

        return false;
//        return
//                getDistance(y, r.getY()) + r.getHeight() / 2 <= height / 2 &&
//                        getDistance(x, r.getX()) + r.getWidth() / 2 <= width / 2 &&
//                        height / 2 + r.getHeight() / 2 <= height &&
//                        width / 2 + r.getWidth() / 2 <= width;
    }

    /** Returns true if the specified rectangle
     *   overlaps with this rectangle */
    public boolean overlaps(Rectangle r) {

        double widthX = x + width / 2;
        double widthR = r.getX() - r.getWidth();
        double heightX = y + height / 2;
        double heightR = r.getY() - r.getHeight();
        double distanceY = getDistance(y, r.getY());
        double heightD =  height / 2 + r.getHeight() / 2;
        double distanceX = getDistance(x, r.getX());
        double widthD =  width / 2 + r.getWidth() / 2;

        if( !contains(r) &&  (widthX > widthR || heightX > heightR && distanceY < heightD && distanceX < widthD )) {
            return true;
        }

        return false;

//        return !contains(r) &&
//                ((x + width / 2 > r.getX() - r.getWidth()) ||
//                        (y + height / 2 > r.getY() - r.getHeight())) &&
//
//                (getDistance(y, r.getY()) < height / 2 + r.getHeight() / 2) &&
//                (getDistance(x, r.getX()) < width / 2 + r.getWidth() / 2);
    }

    public boolean isAdjacentTo(Rectangle r) {
        double width1 = x + width / 2;
        double width2 = r.getX() + r.getWidth() / 2 - r.getWidth();
        double height1 = y + height / 2;
        double height2 = r.getY() + r.getHeight() / 2 - r.getHeight();

        if(!contains(r) && !overlaps(r) && width1 == width2 || height1 == height2){
            return true;
        }
        return false;
    }

//    public boolean isAdjacentTo(Rectangle2D otherRectangle, double tolerance) {
//        if(Math.abs(getLeftSide()-otherRectangle.getRightSide())<tolerance||Math.abs(otherRectangle.getLeftSide()-getRightSide())<tolerance)
//        {
//            return !(getTopSide()<otherRectangle.getBottomSide()||otherRectangle.getTopSide()<getBottomSide());
//        }
//        if(Math.abs(getTopSide()-otherRectangle.getBottomSide())<tolerance||Math.abs(otherRectangle.getTopSide()-getBottomSide())<tolerance)
//        {
//            return !(getRightSide()<otherRectangle.getLeftSide()||otherRectangle.getRightSide()<getLeftSide());
//        }
//        return false;
//    }

    private double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }
}