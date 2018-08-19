package Annotations_Training.Example1_Including_Analyzer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class AnnotationsAnalyzer {
    static void missingCases(ArrayList<Integer> casesToImplement, Class<?> classToCheck) {
        for (Method method : classToCheck.getDeclaredMethods())
        {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null)
            {
                int useCaseID = uc.id();
                if (casesToImplement.contains(new Integer(useCaseID))) {
                    System.out.println("Found UseCase with id - " + uc.id() + ", description - " + uc.description());
                    casesToImplement.remove(new Integer(useCaseID));
                }
            }
        }
        if (casesToImplement.size()>0)
        {
            System.out.println("Test cases to implement: ");
            for (int i=0; i< casesToImplement.size() ; i++) {
                if (i == (casesToImplement.size()-1))
                {
                    System.out.print(casesToImplement.get(i) + ".");
                }else
                System.out.print(casesToImplement.get(i) + ", ");
            }
        }else
        {
            System.out.println("All TestCases implemented ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 1,2,3,4,5,6,7,8,9,10);
        missingCases(useCases, PasswordCheckUtils.class);
    }
}
