package apcsa.franklin.inheritance.geo;

/**
 * This interface is for 2D shapes that have area, perimeter and fill methods.
 * It extends Drawable, since all 2D shapes are also Drawable objects.
 */
public interface Shape2D extends Drawable{
    double area();
    double perimeter();
    void fill();
}
