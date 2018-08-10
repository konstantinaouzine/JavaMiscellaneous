package Serialization_Examples.Reset_Serialization_Graph_In_Stream;

import java.io.*;

public class JavaSerializationEffect {
    public void effect() throws Throwable{
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("test.dat"));
        Test xx=new Test();
        for(int i=0;i<10;i++){
            xx.setA(i);
            out.writeObject(xx);
            //out.reset();           	//Reset of serialization graph in stream
        }                       	    // Object will be written only once, after commenting this line
        out.close();
        Test test1[]=new Test[10];
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("test.dat"));
        for(int i=0;i<10;i++)
            test1[i]=(Test)in.readObject();
        in.close();
        for(int i=0;i<10;i++)
            System.out.println("x="+test1[i].getA() + " "+test1[i]);  //If "out.reset()" is commented,
                                                                    // then this line will print same object
                                                                    // with same(first) value of x(x=0)
    }
    public static void main(String[] args) {
        try {
            JavaSerializationEffect xx = new JavaSerializationEffect();
            xx.effect();
        } catch(Throwable ee){ ee.printStackTrace(); }
    }

}
