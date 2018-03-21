package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> allPart = new TreeSet<String>();
        String path = "";
        while (true){
            String file = reader.readLine();
            if (file.equals("end")){
                break;
            }
            else {
                allPart.add(file);
            }
        }
        String full = allPart.first();
        int extNameInd = allPart.first().lastIndexOf('.');

        String fileName = full.substring(0,extNameInd);
        FileOutputStream fos = new FileOutputStream(fileName);
        for(String part : allPart){

            try (FileInputStream fis = new FileInputStream(part)){
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer, 0, buffer.length);
                fos.write(buffer, 0, buffer.length);
                fis.close();
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        fos.close();
    }
}
