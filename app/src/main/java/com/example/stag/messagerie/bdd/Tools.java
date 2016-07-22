package com.example.stag.messagerie.bdd;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by stag on 22/07/2016.
 */
public class Tools {

    public static String getStringFromBufferedReader(BufferedReader bfr) {
        StringBuilder sb =  new StringBuilder();
        String line;

        try {
            while((line = bfr.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
