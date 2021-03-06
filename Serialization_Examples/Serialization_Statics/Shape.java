package Serialization_Examples.Serialization_Statics;

import java.io.Serializable;
import java.util.Random;

public abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3, YELLOW = 4;
    private int xPos, yPos, dimension;
    private static Random rand = new Random();
    private static int counter = 0;

    public abstract void setColor(int color);
    public abstract int getColor();

    Shape(int xVal, int yVal, int dim)
    {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public String toString()
    {
        return getClass() + "color[" + getColor() +"] xPos[" + xPos +"] yPos["  + yPos + "] dim[" +dimension + "]\n";
    }

    public static Shape randomFactory()
    {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3)
        {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }
}
