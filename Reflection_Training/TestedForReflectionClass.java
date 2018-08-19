package Reflection_Training;

public class TestedForReflectionClass {
    String packageAccessStringVar;
    public String publicAccessStringVar;
    protected String protectedAccessStringVar;
    private String privateAccessStringVar;

    public static void publicNoParamsVoidMethod(){
        System.out.println("No params void method");
    }

    public int publicNoParamsIntMethod(){
        System.out.println("No params return int method");
        return 0;
    }

    private static int publicParamsIntMethod(int x, int y){
        System.out.println("Int param, return int method");
        return x + y;
    }



}
