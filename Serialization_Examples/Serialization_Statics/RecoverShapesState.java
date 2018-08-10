package Serialization_Examples.Serialization_Statics;

import java.io.*;
import java.util.List;

public class RecoverShapesState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\ayzin\\Desktop\\Java_files_tests\\Shapes1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        //Line.deserializeStaticState(objectInputStream);
        //Square.deserializeStaticState(objectInputStream);
        List<Shape> shapes = (List<Shape>)objectInputStream.readObject();
        System.out.println(shapes);
    }
}
