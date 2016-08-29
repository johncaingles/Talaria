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
	String filename = "logs.txt";
	String workingDirectory = System.getProperty("user.dir");
	String filePath = workingDirectory + File.separator + filename;
    
    
    public void log(String username, String action){
        try{
            System.out.println("Final filepath : " + filePath);
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String date = new Date().toString();
            bw.write(date +  " " + username + " " + action);
            bw.newLine();
            bw.close();
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
