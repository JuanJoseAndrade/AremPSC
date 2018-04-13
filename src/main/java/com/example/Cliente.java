/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juan
 */
package com.example;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {
    public final static String Heroku = "";
    
    public static void main(String[] args){
        for(int i = 0; i<20; i++){
            Thread cliente = new Cliente();
            cliente.start();
        }
    }

    @Override
    public void run() {
        try {
            getResult("");
            getResult("hello");
            getResult("db");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getResult(String path) throws MalformedURLException {
        URL camino = new URL(Heroku+path);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(camino.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}