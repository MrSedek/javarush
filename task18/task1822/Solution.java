package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();

        try (FileInputStream fis = new FileInputStream(fileName1)){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            String text = new String(buffer);
            String arg = args[0] + " ";
            for (String retval : text.split("\n")) {
                if (retval.startsWith(arg)){
                    System.out.println(retval);
                    return;
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
