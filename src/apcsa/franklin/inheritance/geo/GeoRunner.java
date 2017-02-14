package apcsa.franklin.inheritance.geo;

import apcsa.franklin.inheritance.geo.stddraw.StdDraw;

import java.util.ArrayList;

/**
 * Feel free to play around with these classes and draw your own Shapes.
 */
public class GeoRunner {
    //Width and height for the CANVAS in pixels.
    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 500;
    //Changes the scale of the canvas. The bottom left corner is (-SCALE, -SCALE) and the top right corner is (SCALE, SCALE).
    public static final double SCALE = 10;
    //Set ths boolean to false if you do not want to see a grid.
    public static final boolean SHOW_GRIDLINES = true;

    public static void main(String[] args) {
        setUp();
        ArrayList<Shape2D> shapes = new ArrayList<Shape2D>();

        Point origin = new Point(0, 0);
        Point top = new Point(0, SCALE/2);
        Point right = new Point(SCALE/2, 0);
        Point bottom = new Point(0, -SCALE/2);
        Point left = new Point(-SCALE/2, 0);

        //Create some shapes.
        Rectangle rect = new Rectangle(origin, SCALE/2, SCALE/2);
        Circle circle = new Circle(origin, SCALE/2);
        Triangle tri1 = new Triangle(origin, top, right);
        Triangle tri2 = new Triangle(origin, right, bottom);
        Triangle tri3 = new Triangle(origin, bottom, left);
        Triangle tri4 = new Triangle(origin, left, top);

        //Fill list of shapes with shapes.
        shapes.add(rect);
        shapes.add(circle);
        shapes.add(tri1);
        shapes.add(tri2);
        shapes.add(tri3);
        shapes.add(tri4);

        //For each Drawable object in shapes, set the pen to a random color and draw it.
        StdDraw.setPenRadius(0.010);
        for (Drawable d: shapes) {
            getRandomColor();
            d.draw();
        }

        //For each Shape2D in shapes, if it is a Triangle, then get a random color and fill it.
        for (Shape2D s: shapes) {
            if (s instanceof Triangle) {
                getRandomColor();
                s.fill();
            }
        }
    }

    /**
     * Initializes the canvas size and sets the scale. Also shows the gridlines if SHOW_GRIDLINES is set to true.
     */
    public static void setUp() {
        StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        StdDraw.setXscale(-SCALE - 0.1, SCALE + 0.1);
        StdDraw.setYscale(-SCALE - 0.1, SCALE + 0.1);
        if (SHOW_GRIDLINES)
            drawGrid();
    }

    public static void getRandomColor() {
        StdDraw.setPenColor((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
    }

    /**
     * Draws a grid overlay to where the unit coordinates are. The center of the grid is (0,0).
     */
    public static void drawGrid() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        //horizontal lines
        for (int i = 0; i <= 2 * SCALE; i++){
            StdDraw.line(-SCALE, -SCALE + i, SCALE, -SCALE + i);
        }
        //vertical lines
        for (int i = 0; i <= 2*SCALE; i++){
            StdDraw.line(-SCALE + i, -SCALE, -SCALE + i, SCALE);
        }
        StdDraw.setPenRadius();
    }
}
