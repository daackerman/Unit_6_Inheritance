package apcsa.franklin.inheritance.geo;

/**
 * This class represents a RegularPolygon.
 *
 * It has methods to return the area, and can also determine inscribed and circumscribed circles.
 * If the RegularPolygon has an odd number of sides, then one point is directly above the center.
 * If the RegularPolygon has an even number of sides, then the points are symmetric across the vertical line through
 * the center.
 *
 * Inherits from: Polygon
 */
public class RegularPolygon extends Polygon {
    private Point center;
    private double radius;
    private int sides;

    /**
     * Constructor for a RegularPolygon.
     *
     * @param c the center.
     * @param r the distance to a side.
     * @param sides how many sides.
     */
    public RegularPolygon(Point c, double r, int sides) {
        if (sides < 3) {
            throw new IllegalArgumentException();
        }
        center = new Point(c);
        radius = r;
        this.sides = sides;
        Point[] vertices = new Point[sides];
        if (sides % 2 == 1) {
            vertices[0] = new Point(0, distToVertex());
            for (int i = 1; i <= sides / 2; i++) {
                vertices[i] = new Point(distToVertex() * Math.cos(Math.PI/2 - i * centralAngle()), distToVertex() * Math.sin(Math.PI/2 - i * centralAngle()));
                vertices[sides - i] = new Point(-vertices[i].getX(), vertices[i].getY());
            }
        } else {
            for (int i = 0; i < sides / 2; i++) {
                vertices[i] = new Point(distToVertex() * Math.cos(Math.PI/2 - centralAngle()/2 - i * centralAngle()),
                        distToVertex() * Math.sin(Math.PI/2 - centralAngle()/2 - i * centralAngle()));
                vertices[sides - i - 1] = new Point(-vertices[i].getX(), vertices[i].getY());
            }
        }
        setVertices(vertices);
        translate(c.getX(), c.getY());
    }

    /**
     * Constructor makes a unit n-gon with sides sides centered at the origin.
     * @param sides number of sides.
     */
    public RegularPolygon(int sides) {
        this(new Point(), 1, sides);
    }

    private double distToVertex() {
        return radius / Math.cos(centralAngle()/2);
    }

    private double centralAngle() {
        return 2 * Math.PI/sides;
    }

    private double sideLength() {
        return Math.tan(centralAngle() / 2) * radius * 2;
    }

    /**
     * getCenter method.
     * @return the center of this RegularPolygon.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * getInscribedCircle method.
     * @return the Circle that is tangent to the sides of this RegularPolygon.
     */
    public Circle getInscribedCircle() {
        return new Circle(center, radius);
    }

    /**
     * getCircumscribedCircle method.
     * @return the Circle that contains the vertices of this RegularPolygon.
     */
    public Circle getCircumscribedCircle() {
        return new Circle(center, distToVertex());
    }

    /**
     * area method.
     * @return the area of this RegularPolygon.
     */
    public double area() {
        return sides * sideLength() * radius / 2;
    }
}
