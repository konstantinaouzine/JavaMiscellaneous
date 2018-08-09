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
        System.out.println(shapes);

        File file = new File("C:\\Users\\ayzin\\Desktop\\Java_files_tests\\Shapes1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(shapes);
    }
}
