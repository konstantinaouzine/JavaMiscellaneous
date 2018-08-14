package ENUM_Usage_Examples.Chain_Of_Responsibility_Using_Enums;

import java.util.Iterator;
import java.util.Random;

public class CV {
    enum TECHNOLOGIES_STACK_KNOWN {YES, PARTLY, SOME, NO};
    enum YEARS_OF_EXP {MORE_THEN_7, FIVE, FOUR, JUNIOR};
    enum FAST_LERNER {YES, NO1, NO2, NO3};
    enum SELF_LEARN_JAVA {NO1, NO2, NO3, YES};

    private static Random rand = new Random();
    TECHNOLOGIES_STACK_KNOWN technologiesStackKnown;
    YEARS_OF_EXP yearsOfExp;
    FAST_LERNER fastLerner;
    SELF_LEARN_JAVA selfLearnJava;

    private static int globalCounter = 0;
    private int id = ++globalCounter;

    public String toString(){
        return "CV" + id + " - ";
    }

    public String details(){
        return toString() +
                " Stack: " + technologiesStackKnown +
                ", Years of exp: " + yearsOfExp +
                ", fast learner: " + fastLerner +
                ", self learned Java " + selfLearnJava + ".";
    }

    public static CV randomCV(){
        CV cv = new CV();
        cv.technologiesStackKnown = TECHNOLOGIES_STACK_KNOWN.values()[rand.nextInt(TECHNOLOGIES_STACK_KNOWN.values().length)];
        cv.yearsOfExp = YEARS_OF_EXP.values()[rand.nextInt(YEARS_OF_EXP.values().length)];
        cv.fastLerner= FAST_LERNER.values()[rand.nextInt(FAST_LERNER.values().length)];
        cv.selfLearnJava= SELF_LEARN_JAVA.values()[rand.nextInt(SELF_LEARN_JAVA.values().length)];
        return cv;
    }

    public static Iterable<CV> cvGenerator(final int count){
        return new Iterable<CV>() {
            int n = count;

            @Override
            public Iterator<CV> iterator() {
                return new Iterator() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Object next() {
                        return randomCV();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
