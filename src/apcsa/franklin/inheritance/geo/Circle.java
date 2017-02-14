package apcsa.franklin.inheritance.geo;

/**
 * This class represents a circle. It inherits all of its functionality from Ellipse,
 * a more generalized circle.
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
}
