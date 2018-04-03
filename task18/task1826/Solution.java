package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) {
        String key = args[0];
        String fileName = args[1];
        String fileOuntputName = args[2];

        try (FileInputStream fis = new FileInputStream(fileName)){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            switch (key){
                case "-e":
                {
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte)(buffer[i]+1);
                    }
                    break;
                }
                case "-d":
                {
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte)(buffer[i]-1);
                    }
                    break;
                }
            }
            FileOutputStream fos = new FileOutputStream(fileOuntputName);
            fos.write(buffer, 0, buffer.length);
            fis.close();
            fos.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
