package apcsa.franklin.inheritance.geo;

import apcsa.franklin.inheritance.geo.stddraw.StdDraw;

/**
 * This class represents a Rectangle.
 *
 * It has a constructor that takes a Point and two lengths representing half of the width and half of the height
 * for this Rectangle. It also has two methods that return the width and height of the Rectangle. The area is calculated
 * using width * height. It implements its own translate, draw, area, perimeter and fill methods.
 *
 * Inherits from: Polygon
 * Subclasses: Square
 */
public class Rectangle extends Polygon {
    //Center of the Rectangle
    private Point center;
    //Half the width
    private double dx;
    //Half the height
    private double dy;

    /**
     * Constructor for a Rectangle.
     *
     * Takes a Point for the center of the Rectangle, half the width, and half the height to determine the
     * dimensions of the Rectangle.
     * @param center the center of the Rectangle.
     * @param dx half the width.
     * @param dy half the height.
     */
    public Rectangle(Point center, double dx, double dy) {
        if (dx <= 0 || dy <= 0){
            throw new IllegalArgumentException("Invalid dimensions");
        }
        this.center = new Point(center);
        this.dx = dx;
        this.dy = dy;
        Point topLeft = new Point(center.getX() - dx, center.getY() + dy);
        Point topRight = new Point(center.getX() + dx, center.getY() + dy);
        Point bottomRight = new Point(center.getX() + dx, center.getY() - dy);
        Point bottomLeft = new Point(center.getX() - dx, center.getY() - dy);
        setVertices(new Point[]{topLeft, topRight, bottomRight, bottomLeft});
    }

    //Return the width and height of this rectangle.
    public double width() {
        return 2 * dx;
    }

    public double height() {
        return 2 * dy;
    }

    //Drawable methods
    @Override
    public void translate(double dx, double dy) {
        super.translate(dx, dy);
        center.translate(dx, dy);
    }

    @Override
    public void draw() {
        StdDraw.rectangle(center.getX(), center.getY(), dx, dy);
    }

    //Shape2D methods
    @Override
    public double area() {
        return width() * height();
    }

    @Override
    public double perimeter() {
        return 2 * width() + 2 * height();
    }

    @Override
    public void fill() {
        StdDraw.filledRectangle(center.getX(), center.getY(), dx, dy);
    }
}
