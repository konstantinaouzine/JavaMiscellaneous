package Serialization_Statics;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Line extends Shape {
    private static int color = RED;   //initialized as static member of the class

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    //This method allows to overwrite the default serialization method and serialize static fields if necessary
    private void writeObject(ObjectOutputStream os) throws IOException{
        os.defaultWriteObject();
        os.writeInt(color);
    }

    //This method allows reading static fields during deserialization
    private void readObject(ObjectInputStream os) throws IOException, ClassNotFoundException {
        os.defaultReadObject();
        color = os.readInt();
    }


    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}
