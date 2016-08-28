package controller;

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
    
    
    
    public void log(String username, String action){
        try{
            FileWriter fw = new FileWriter("logs.txt", true);
            String date = new Date().toString();
            fw.write(date +  " " + username + " " + action + "\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
