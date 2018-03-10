package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available()>0){
            int count = 0;
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                if (((i>=97)&&(i<=122))||((i>=65)&&(i<=90)))
                    count++;
            }
            System.out.println(count);
        }
        fileInputStream.close();

    }
}
