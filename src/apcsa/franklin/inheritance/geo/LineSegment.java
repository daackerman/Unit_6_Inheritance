package apcsa.franklin.inheritance.geo;

import apcsa.franklin.inheritance.geo.stddraw.StdDraw;

/**
 * This class represents a LineSegment.
 *
 * It is defined by two points. It has getLength and getSlope methods that return the length and getSlope of a LineSegment.
 * It also has draw and translate methods so that it can implement the Drawable interface.
 *
 * Implements: Drawable.
 */
public class LineSegment implements Drawable {
    //Endpoints of the LineSegment
    private Point endPoint1;
    private Point endPoint2;

    //Constructors
    public LineSegment(Point p1, Point p2) {
        if (p1.equals(p2)) {
            throw new IllegalArgumentException("Invalid segment");
        }
        setEndPoint1(p1);
        setEndPoint2(p2);
    }

    public LineSegment(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    //Setters
    public void setEndPoint1(Point endPoint1) {
        if (endPoint1.equals(endPoint2)) {
            throw new IllegalArgumentException("Endpoints must be unique");
        }
        this.endPoint1 = new Point(endPoint1);
    }

    public void setEndPoint2(Point endPoint2) {
        if (endPoint2.equals(endPoint1)) {
            throw new IllegalArgumentException("Endpoints must be unique");
        }
        this.endPoint2 = new Point(endPoint2);
    }

    //Getters
    public Point getEndPoint1() {
        return endPoint1;
    }

    public Point getEndPoint2() {
        return endPoint2;
    }

    /**
     * getLength method.
     * @return the length of the LineSegment.
     */
    public double getLength() {
        return endPoint1.distanceTo(endPoint2);
    }

    /**
     * getSlope method.
     * @return the getSlope of this line.
     */
    public double getSlope() {
        return endPoint1.getSlope(endPoint2);
    }

    //Drawable methods.
    /**
     * Translates this LineSegment dx in the x direction and dy in the y direction.
     * @param dx amount to move left/right.
     * @param dy amount to move up/down.
     */
    @Override
    public void translate(double dx, double dy) {
        endPoint1.translate(dx, dy);
        endPoint2.translate(dx, dy);
    }

    /**
     * Draws this LineSegment using StdDraw.
     */
    @Override
    public void draw() {
        StdDraw.line(endPoint1.getX(), endPoint1.getY(), endPoint2.getX(), endPoint2.getY());
    }
}
