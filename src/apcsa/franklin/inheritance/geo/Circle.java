package apcsa.franklin.inheritance.geo;

/**
 * This class represents a Circle.
 *
 * Most of its functionality comes from Ellipse, but it can also find inscribed and circumscribed regular polygons.
 * It has a getRadius method that returns the radius of the Circle.
 *
 * Inherits from: Ellipse
 */
public class Circle extends Ellipse {
    /**
     * Constructor for a circle.
     * @param center the center of the circle.
     * @param r the radius of the circle.
     */
    public Circle(Point center, double r) {
        super(center, r, r);
    }

    public double getRadius() {
        return getMajorAxis();
    }

    public RegularPolygon getInscribedPolygon(int sides) {
        double centralAngle = 2 * Math.PI / sides;
        return new RegularPolygon(getCenter(), getRadius() * Math.cos(centralAngle / 2), sides);
    }

    public RegularPolygon getCircumscribedPolygon(int sides) {
        return new RegularPolygon(getCenter(), getRadius(), sides);
    }
}
