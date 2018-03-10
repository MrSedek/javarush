package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        byte[] buffer1 = null;
        byte[] buffer2 = null;

        try (FileInputStream fis = new FileInputStream(file1)){
            buffer1 = new byte[fis.available()];
            fis.read(buffer1, 0, buffer1.length);
            fis.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(file2)){
            buffer2 = new byte[fis.available()];
            fis.read(buffer2, 0, buffer2.length);
            FileOutputStream fos = new FileOutputStream(file1);
            fos.write(buffer2, 0, buffer2.length);
            fos.write(buffer1,0,buffer1.length);
            fos.close();
            fis.close();
        }

    }
}
