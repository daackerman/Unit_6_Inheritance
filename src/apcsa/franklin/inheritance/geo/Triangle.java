package apcsa.franklin.inheritance.geo;

/**
 * This class represents a Triangle.
 *
 * Throws an IllegalArgumentException if the three points used to construct this Triangle are collinear.
 * It can calculate its area and it inherits draw, translate, perimeter and fill from Polygon.
 *
 * Inherits from: Polygon
 */
public class Triangle extends Polygon {
    /**
     * Constructor for a Triangle. It takes three points that are not collinear and sets the vertices of a Polygon
     * to those points.
     *
     * @param a one vertex
     * @param b a second vertex
     * @param c a third vertex
     */
    public Triangle(Point a, Point b, Point c) {
        if (validTriangle(a, b, c)) {
            setVertices(new Point[]{a, b, c});
        } else {
            throw new IllegalArgumentException("Not a triangle.");
        }
    }

    /**
     * A triangle is only valid if the three points are not collinear.
     * @return true if the points are not collinare,
     *         false otherwise.
     */
    private boolean validTriangle(Point a, Point b, Point c) {
        return !a.isCollinear(b, c);
    }

    /**
     * Area method is calculated using Heron's formula A = Math.sqrt(s(s-a)(s-b)(s-c)) where
     * s is the semiperimeter.
     * @return the area of this triangle.
     */
    public double area() {
        double s = perimeter() / 2;
        Point[] vertices = getVertices();
        return Math.sqrt(s * (s - vertices[0].distanceTo(vertices[1])) *
                (s - vertices[1].distanceTo(vertices[2])) *
                (s - vertices[0].distanceTo(vertices[2])));
    }
}
