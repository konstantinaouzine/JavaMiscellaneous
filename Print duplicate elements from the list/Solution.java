package com.javarush.task.task04.task0417;

/* 
Do we have a pair?
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> listOfParams = prepareListOfParameters(3);
        printList(prepareListForPrinting(listOfParams));
    }

    private static void printList(List<Integer> _listToPrint)
    {
        for (int i=0; i<_listToPrint.size(); i++)
        {
            System.out.print(_listToPrint.get(i) + " ");
        }
    }

    private static int readFromKeyboard() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
    }

    private static List<Integer> prepareListOfParameters(int amountOfNumbers) throws IOException {
        List<Integer> myList = new ArrayList<>();
        for (int i=0; i<amountOfNumbers; i++)
        {
            myList.add(readFromKeyboard());
        }
        return myList;
    }

    private static List<Integer> prepareListForPrinting(List<Integer> _list)
    {
        List<Integer> dupList = new ArrayList<>(_list);
        List<Integer> listToPrint = new ArrayList<>();

        for (int i=0; i< _list.size(); i++) {
            Integer temp = _list.get(i);
            dupList.remove(temp);
            if (dupList.contains(temp)) {
                if (listToPrint.isEmpty())
                    listToPrint.add(temp);
                listToPrint.add(temp);
            }
        }
        return listToPrint;
    }
}