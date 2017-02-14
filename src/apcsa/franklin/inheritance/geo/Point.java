package apcsa.franklin.inheritance.geo;

import apcsa.franklin.inheritance.geo.stddraw.StdDraw;

/**
 * This class represents a Point object.
 *
 * It has an x and a y coordinate and can calculate distance from itself to another Point. It also has
 * an equals method to determine if it is the same as another point (same x and y). It can also determine the slope
 * between points and can determine if three points all lie on the same line. Since Point is Drawable,
 * it has a translate and a draw method.
 *
 * Implements: Drawable.
 */
public class Point implements Drawable {
    //x and y coordinates
    private double x;
    private double y;

    //Constructors
    public Point(double x_in, double y_in) {
        setX(x_in);
        setY(y_in);
    }

    public Point(Point other) {
        setX(other.x);
        setY(other.y);
    }

    //Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    //Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * distanceTo method. Calculates the distance between this Point and other Point.
     * @param other the other Point.
     * @return distance between Points.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.y - y, 2) + Math.pow(other.x - x, 2));
    }

    /**
     * Calculates the between this and Point other.
     * @param other the other Point.
     * @return the getSlope if the line is not vertical,
     *         NaN if it is.
     */
    public double getSlope(Point other) {
        if (other.x == x) {
            return Double.NaN;
        } else {
            return (other.y - y) / (other.x - x);
        }
    }

    /**
     * Determines if this and two other points lie on the same line.
     * @param a a Point.
     * @param b another Point.
     * @return true if the three points lie on the same line,
     *         false otherwise.
     */
    public boolean isCollinear(Point a, Point b) {
        return (this.equals(a) || this.equals(b) || a.equals(b)) ||
                Math.abs(this.getSlope(a) - this.getSlope(b)) <= 0.001;
    }

    //Equals method.
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point other = (Point)o;
            return other.y == y && other.x == x;
        }
        return false;
    }

    /**
     * translate method.
     * @param dx amount to translate left/right.
     * @param dy amount to translate up/down.
     */
    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Draws this point using StdDraw.
     */
    @Override
    public void draw() {
        StdDraw.point(x, y);
    }
}
