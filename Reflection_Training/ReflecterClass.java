package Reflection_Training;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class ReflecterClass {
    public static void main(String[] args) throws ClassNotFoundException {
        TestedForReflectionClass test1 = new TestedForReflectionClass();
        Class cl = Class.forName("Reflection_Training.TestedForReflectionClass");
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods)
        {
            //We look for method that takes 2 'int' parameters and return 'int'
            //Then we check whether this method 'protected' or not
            //If so, then we grant permission to use the method
            System.out.println(method.getName());
            Class<?> returnType = method.getReturnType();
            if (!returnType.getSimpleName().equalsIgnoreCase("int"))
                continue;
            int paramsCount = method.getParameterCount();
            if (paramsCount!=2)
                continue;
            Class[] paramsClasses = method.getParameterTypes();
            for (Class someParamClass : paramsClasses)
            {
                if (!someParamClass.getSimpleName().equalsIgnoreCase("int"))
                    continue;
            }
            if (method.isAccessible()==false) {
                System.out.println("Private method, giving access");
                method.setAccessible(true);
            }
            try {
                int value = (Integer)method.invoke(null,5,6);
                System.out.println(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }

}
