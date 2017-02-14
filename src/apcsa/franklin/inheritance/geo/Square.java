package apcsa.franklin.inheritance.geo;

/**
 * This class represents a Square. The only distinction between a Square and a Rectangle is the constructor.
 * Squares have the same dimensions in both x and y directions, so a Square only needs to know one dimension.
 *
 * Inherits from: Rectangle
 */
public class Square extends Rectangle {
    /**
     * Constructor for a Square
     * @param center the center of the Square.
     * @param dx half of a side length.
     */
    public Square(Point center, double dx) {
        super(center, dx, dx);
    }
}