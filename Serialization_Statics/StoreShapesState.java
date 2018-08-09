package Serialization_Statics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreShapesState {
    public static void main(String[] args) throws IOException {
        List<Shape> shapes = new ArrayList<>();
        for (int i=0; i<10 ;i++)
        {
            shapes.add(Shape.randomFactory());
        }
        for(int i = 0; i < 10; i++) {
            Shape shape = shapes.get(i);
            if(shape instanceof Circle)
                shape.setColor(Shape.BLUE);
            else if(shape instanceof Square)
                shape.setColor(Shape.GREEN);
            else if(shape instanceof Line)
                shape.setColor(Shape.YELLOW);
        }

        File file = new File("C:\\Users\\ayzin\\Desktop\\Java_files_tests\\Shapes1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        //Line.serializeStaticState(objectOutputStream);
        //Square.serializeStaticState(objectOutputStream);
        objectOutputStream.writeObject(shapes);
    }
}
