package apcsa.franklin.inheritance.geo;

/**
 * Created by David on 2/11/2017.
 */
public class RegularHexagon extends Polygon {
    private double radius;

    public RegularHexagon(Point center, double r) {
        radius = r;
        Point topLeft = new Point(center.getX() - getSideLength() / 2, center.getY() + radius);
        Point topRight = new Point(center.getX() + getSideLength() / 2, center.getY() + radius);
        Point right = new Point(center.getX() + getSideLength(), center.getY());
        Point botRight = new Point(center.getX() + getSideLength() / 2, center.getY() - radius);
        Point botLeft = new Point(center.getX() - getSideLength() / 2, center.getY() - radius);
        Point left = new Point(center.getX() - getSideLength(), center.getY());
        setVertices(new Point[]{topLeft, topRight, right, botRight, botLeft, left});
    }
    private double getSideLength() {
        return radius * 2 / Math.sqrt(3);
    }

    public double area() {
        return 3 * radius * getSideLength();
    }
}
