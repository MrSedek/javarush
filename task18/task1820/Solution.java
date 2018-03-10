package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        try (FileInputStream fis = new FileInputStream(file1)){
            FileWriter fos = new FileWriter(file2);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            String s = "";
            for (int i = 0; i < buffer.length; i++) {
                s = s + (char)buffer[i];
                if (((char)buffer[i] == ' ')||(i==buffer.length-1)){
                    float numS = Float.parseFloat(s);
                    int num = (int)Math.round(numS);

                    fos.write(String.valueOf(num) + " ");
                    s = "";


//                    System.out.println(numS + " --- " + num);
                }
            }
            fos.flush();
            fos.close();
            fis.close();
        }


    }
}
