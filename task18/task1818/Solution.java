package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);


        try (FileInputStream fileInputStream2 = new FileInputStream(fileName2)){
            byte[] buffer = new byte[fileInputStream2.available()];
            fileInputStream2.read(buffer, 0, buffer.length);
            fileOutputStream1.write(buffer, 0, buffer.length);
            fileInputStream2.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try (FileInputStream fileInputStream3 = new FileInputStream(fileName3)){
            byte[] buffer = new byte[fileInputStream3.available()];
            fileInputStream3.read(buffer, 0, buffer.length);
            fileOutputStream1.write(buffer,0,buffer.length);
            fileInputStream3.close();

        }
        fileOutputStream1.close();
    }
}
