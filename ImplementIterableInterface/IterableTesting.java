package com.javarush.task.task08.task0801.ImplementIterableInterface;

import java.util.Iterator;

public class IterableTesting {

    public static void main(String[] args) {
    Integer[] numbers = new Integer[]{1,2,3,4,5};
    SpecialBox<Integer> numsBox = new SpecialBox<>(numbers);
    for (Object num : numsBox)
    {
        System.out.print((Integer)num);
    }

    System.out.println("");

    Human[] people = new Human[]{new Human("vasya"), new Human("petya")};
    SpecialBox<Human> specialBox = new SpecialBox<Human>(people);

    for (Object human : specialBox)
    {
        System.out.println((Human)human);
    }

    }
    public static class SpecialBox<Type> implements Iterable
    {
        private Type[] humanArr;
        SpecialBox(Type[] _humanArr)
        {
            this.humanArr = _humanArr;
        }
        @Override
        public Iterator<Type> iterator() {
            Iterator<Type> it = new Iterator<Type>(){
                private int curIndex = 0;

                @Override
                public boolean hasNext() {
                    return (curIndex < humanArr.length) && (humanArr[curIndex]!=null);
                }

                @Override
                public Type next()
                {
                    return humanArr[curIndex++];
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("remove operation not supported by human array");
                }
            };
            return it;
        }
    }
    public static class Human{
        private String name;
        public Human(String _name)
        {
            this.name = _name;
        }
        public String toString()
        {
            return this.name;
        }
    }
}
