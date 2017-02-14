package apcsa.franklin.inheritance.geo;

/**
 * This interface represents Drawable objects.
 * All Drawable objects must have draw and translate methods.
 */
public interface Drawable {
    void draw();
    void translate(double dx, double dy);
}
