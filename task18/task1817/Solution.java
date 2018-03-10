package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int countspace = 0;
        int countall = 0;
        int i = -1;

//        System.out.println(args[0]);

        while (fileInputStream.available()>0){
            while ((i = fileInputStream.read()) != -1) {
                countall++;
                if (i == 32) countspace++;
            }
        }
        fileInputStream.close();
//        System.out.println(countall);
//        System.out.println(countspace);
        float rez = countspace/countall*100;
//        System.out.println(rez);
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        System.out.println(decimalFormat.format((double)countspace/countall*100));
    }
}