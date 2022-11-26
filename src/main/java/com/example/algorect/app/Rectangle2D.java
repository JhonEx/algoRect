package com.example.algorect.app;
//https://stackoverflow.com/questions/20449084/detecting-rectangle-adjacency-in-java

public class Rectangle2D {
   /* private double x;       // x-value of upper-left corner of rectangle
    private double y;       // y-value of upper-left corner of rectangle
    private double width;   // width of the rectangle
    private double height;  // height of the rectangle

    // Returns true if this Rectangle intersects otherRectangle.
    public boolean intersects(Rectangle2D otherRectangle) {
        double x = otherRectangle.getX();
        double y = otherRectangle.getY();
        double w = otherRectangle.getWidth();
        double h = otherRectangle.getHeight();
        double x0 = getX();
        double y0 = getY();

        if(isEmpty() || w <= 0 || h <= 0)
            return false;

        return (
                x + w > x0 &&
                        y + h > y0 &&
                        x < x0 + getWidth() &&
                        y < y0 + getHeight()
        );
    }

    // Returns true if this Rectangle contains otherRectangle.
    public boolean contains(Rectangle2D otherRectangle) {
        double x = otherRectangle.getX();
        double y = otherRectangle.getY();
        double w = otherRectangle.getWidth();
        double h = otherRectangle.getHeight();
        double x0 = getX();
        double y0 = getY();

        return (
                x >= x0 &&
                        y >= y0 &&
                        x < x0 + getWidth() &&
                        y < y0 + getHeight()
        );
    }

    // Returns true if this Rectangle is adjacent to otherRectangle.
    public boolean isAdjacentTo(Rectangle2D otherRectangle, double tolerance) {
        if(Math.abs(getLeftSide()-otherRectangle.getRightSide())<tolerance||Math.abs(otherRectangle.getLeftSide()-getRightSide())<tolerance)
        {
            return !(getTopSide()<otherRectangle.getBottomSide()||otherRectangle.getTopSide()<getBottomSide());
        }
        if(Math.abs(getTopSide()-otherRectangle.getBottomSide())<tolerance||Math.abs(otherRectangle.getTopSide()-getBottomSide())<tolerance)
        {
            return !(getRightSide()<otherRectangle.getLeftSide()||otherRectangle.getRightSide()<getLeftSide());
        }
        return false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }*/
}