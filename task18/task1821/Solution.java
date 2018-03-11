package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Character,Integer> map = new TreeMap<>();
        Integer count;
        try (FileInputStream fis = new FileInputStream(args[0])){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0 , buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                char ch = (char) buffer[i];
                if (map.containsKey(ch)){
                    count = map.get(ch);
                    count++;
                    map.put(ch,count);
                }
                else
                {
                    map.put(ch,1);
                }
            }
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Character, Integer> me : map.entrySet()) {
            System.out.println(me.getKey() + " " + me.getValue());
        }
    }
}
