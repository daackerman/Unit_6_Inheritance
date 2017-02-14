package apcsa.franklin.inheritance.geo;

import apcsa.franklin.inheritance.geo.stddraw.StdDraw;

/**
 * This class represents an Ellipse which has a center, width and height.
 *
 * Implements: Shape2D
 */
public class Ellipse implements Shape2D {
    private Point center;
    private double dx;
    private double dy;

    /**
     * Constructor for an Ellipse at a given center with a certain width and height.
     * @param center the center of the ellipse.
     * @param dx half the width.
     * @param dy half the height.
     */
    public Ellipse(Point center, double dx, double dy) {
        if (dx <= 0 || dy <= 0) {
            throw new IllegalArgumentException("Invalid Ellipse");
        }
        this.center = new Point(center);
        this.dx = dx;
        this.dy = dy;
    }

    //Drawable methods
    /**
     * Translate method.
     * @param dx amount to move in the x direction.
     * @param dy amount to move in the y direction.
     */
    @Override
    public void translate(double dx, double dy) {
        center.translate(dx, dy);
    }

    /**
     * Draws this Ellipse using StdDraw.
     */
    @Override
    public void draw() {
        StdDraw.ellipse(center.getX(), center.getY(), dx, dy);
    }

    //Shape2D methods.
    /**
     * Area method.
     * @return returns the area of this ellipse.
     */
    @Override
    public double area() {
        return Math.PI * dx * dy;
    }

    /**
     * Perimeter method.
     * @return an approximation of the perimeter of this ellipse.
     */
    @Override
    public double perimeter() {
        return 2* Math.PI * Math.sqrt((dx * dx + dy * dy) / 2);
    }

    /**
     * Fills this Ellipse using StdDraw.
     */
    @Override
    public void fill() {
        StdDraw.filledEllipse(center.getX(), center.getY(), dx, dy);
    }
}
