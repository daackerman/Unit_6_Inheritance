package apcsa.franklin.inheritance.geo;

import apcsa.franklin.inheritance.geo.stddraw.StdDraw;

/**
 * This class represents a Polygon which is a 2D shape. All polygons have a number of vertices
 * and draw and fill methods. We can easily calculate the perimeter of a polygon, but we leave
 * finding the area up to its subclasses which use difference formulas.
 *
 * Implements: Shape2D
 * Subclasses: Rectangle, Triangle, Square.
 */
public abstract class Polygon implements Shape2D {
    //Array of this Polygon's vertices.
    private Point[] vertices;

    //Set and Get methods for vertices.
    public void setVertices(Point[] points) {
        vertices = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            vertices[i] = new Point(points[i]);
        }
    }

    public int getSides() {
        return vertices.length;
    }

    public Point[] getVertices() {
        return vertices;
    }

    //Retrieves an array of all the vertices x values.
    private double[] getXs() {
        double[] x = new double[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            x[i] = vertices[i].getX();
        }
        return x;
    }

    //Retrieves an array of all the vertices y values.
    private double[] getYs() {
        double[] y = new double[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            y[i] = vertices[i].getY();
        }
        return y;
    }

    //Calculates the perimeter of a Polygon
    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < vertices.length - 1; i++) {
            sum += vertices[i].distanceTo(vertices[i + 1]);
        }
        sum += vertices[0].distanceTo(vertices[vertices.length - 1]);
        return sum;
    }

    /**
     * Translates each vertex dx units left/right and dy units up/down.
     */
    public void translate(double dx, double dy) {
        for (Point p: vertices) {
            p.translate(dx, dy);
        }
    }

    /**
     * Draw's the polygon using StdDraw.polygon(double[] x, double[] y)
     */
    public void draw() {
        StdDraw.polygon(getXs(), getYs());
    }

    /**
     * Fills the polygon using StdDraw.filledPolygon(double[] x, double[] y)
     */
    public void fill() {
        StdDraw.filledPolygon(getXs(), getYs());
    }
}
