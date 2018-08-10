package Serialization_Examples.Reset_Serialization_Graph_In_Stream;

import java.io.Serializable;

public class Test implements Serializable {
    private int x;

    void setA(int val)
    {
        this.x = val;
    }

    int getA()
    {
        return x;
    }
}