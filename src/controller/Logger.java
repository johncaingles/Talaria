package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Logger {
    File file = new File("logs.txt");
    
    
    public void log(String username, String action){
        try{
            if(!file.exists()){
                System.out.println("file created");
                file.createNewFile();
            }
            FileWriter fw = new FileWriter("logs.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            String date = new Date().toString();
            bw.write(date +  " " + username + " " + action);
            bw.newLine();
            System.out.println(file.getAbsolutePath());
            bw.close();
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
