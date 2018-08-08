package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Read file name from console
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = buf.readLine();
        buf.close();
        //Creating reader to read from file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        StringBuilder stringBuilder = new StringBuilder();
        //Read lines from file and build a big line that contains all the content
        while(bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            stringBuilder.append(line);
        }
        bufferedReader.close();
        //All content of the file now stays as one string
        String input = stringBuilder.toString();
        //Create 2 arrays of starting position of tags
        ArrayList<Integer> openTags = new ArrayList<>();
        ArrayList<Integer> closeTags = new ArrayList<>();
        //Use a method that finds all starting and ending positions of necessary tag via recursion
        String tag = "<" + args[0];
        countAppearance(0,0, input, tag, openTags);
        tag = "</" + args[0];
        countAppearance(0,0, input, tag, closeTags);
        //System.out.println(openTags);
        //System.out.println(closeTags);

        //Creating and filling map of pairs: starting tag and its corresponding closure tag
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer value : closeTags)
        {
            for (int i=openTags.size()-1; i>-1 ; i--)
            {
                if (openTags.get(i)<value)
                {
                    map.put(openTags.get(i), value+3+args[0].length());
                    openTags.remove(i);
                    break;
                }
            }
        }
        //Sorting the list in order to print the data in necessary order: from first occurrence of opening tag
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        //printing the data
        for (Integer value : list)
        {
            System.out.println(input.substring(value, map.get(value)));
        }
    }

    private static int countAppearance(int currentIndex, int count, String big, String small, ArrayList<Integer> list)
    {
        int countToReturn = count;
        if (big.indexOf(small, currentIndex) != -1)
        {
            list.add(big.indexOf(small, currentIndex));
            count++;
            currentIndex = big.indexOf(small, currentIndex)+1;
            countToReturn = countAppearance(currentIndex, count, big, small, list);
        }
        return countToReturn;
    }
}
