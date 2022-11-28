package com.example.algorect.app.rec;

import java.util.Scanner;

public class Rectangle {

    public static class Point {

        public final float x, y;
        public final static Point ORIGIN = new Point(0, 0);

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public Point shift(float dx, float dy) {
            return new Point(x + dx, y + dy);
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
    public final Point topLeft, bottomRight;

    /**
     * Create a rectangle with given coordinate
     *
     * @param x0 top left
     * @param y0 top left
     * @param x1 bottom right
     * @param y1 bottom right
     */
    public Rectangle(float x0, float y0, float x1, float y1) {
        // make sure that x0 < x1 and y0 > y1
        if (x0 > x1) {
            float temp = x1;
            x1 = x0;
            x0 = temp;
        }
        if (y0 < y1) {
            float temp = y1;
            y1 = y0;
            y0 = temp;
        }
        topLeft = new Point(x0, y0);
        bottomRight = new Point(x1, y1);
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this(topLeft.x, topLeft.y, bottomRight.x, bottomRight.y);
    }

    public Rectangle unify(Rectangle other) {
        float x0 = Math.min(topLeft.x, other.topLeft.x);
        float y0 = Math.max(topLeft.y, other.topLeft.y);
        float x1 = Math.max(bottomRight.x, other.bottomRight.x);
        float y1 = Math.min(bottomRight.y, other.bottomRight.y);
        return new Rectangle(x0, y0, x1, y1);
    }

    public boolean contains(Point p) {
        if (p.x >= topLeft.x && p.x <= bottomRight.x
                && p.y <= topLeft.y && p.y >= bottomRight.y) {
            return true;
        }
        return false;
    }

    public Rectangle shift(float dx, float dy) {
        return new Rectangle(topLeft.shift(dx, dy), bottomRight.shift(dx, dy));
    }

    public boolean isInter(Rectangle other) {
        if (other.bottomRight.x < topLeft.x
                || other.bottomRight.y > topLeft.y
                || other.topLeft.y < bottomRight.y
                || other.topLeft.x > bottomRight.x) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rect(" + topLeft.toString() + ", " + bottomRight.toString() + ")";
    }

    public Rectangle intersection(Rectangle other) {
        if (!isInter(other)) return null;

        float x0 = Math.max(topLeft.x, other.topLeft.x);
        float y0 = Math.min(topLeft.y, other.topLeft.y);
        float x1 = Math.min(bottomRight.x, other.bottomRight.x);
        float y1 = Math.max(bottomRight.y, other.bottomRight.y);
        return new Rectangle(x0, y0, x1, y1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle r1 = inputRectangle(scanner);
        System.out.println("Rectangle 1: " + r1.toString());

        Rectangle r2 = inputRectangle(scanner);
        System.out.println("Rectangle 2: " + r2.toString());

        System.out.println("Unification: " + r1.unify(r2).toString());

        if (!r1.isInter(r2)) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersection: " + r1.intersection(r2).toString());
        }

        System.out.print("Enter a point: ");
        Point p = new Point(scanner.nextFloat(), scanner.nextFloat());
        System.out.println("Point is" + (r1.contains(p) ? "" : " NOT") + " in rectangle 1");
        System.out.println("Point is" + (r2.contains(p) ? "" : " NOT") + " in rectangle 2");

        System.out.print("Enter a vector to shift: ");
        float dx = scanner.nextFloat();
        float dy = scanner.nextFloat();
        System.out.println("Result 1: " + r1.shift(dx, dy).toString());
        System.out.println("Result 2: " + r2.shift(dx, dy).toString());
    }

    private static Rectangle inputRectangle(Scanner scanner) {
        System.out.println("Enter rectangle:");
        System.out.print("    top left point: ");
        float x0 = scanner.nextFloat();
        float y0 = scanner.nextFloat();

        System.out.print("    bottom right point: ");
        float x1 = scanner.nextFloat();
        float y1 = scanner.nextFloat();

        return new Rectangle(x0, y0, x1, y1);
    }
}