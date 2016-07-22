package com.example.stag.messagerie.bdd;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by stag on 22/07/2016.
 */
public class HttpAsyncTask extends AsyncTask<String, String, String> {

    private User user;
    public HttpAsyncTask(User user) {
        this.user = user;
    }

    @Override
    protected void onPreExecute() {
        // super.onPreExecute();
    }

    @Override

    protected String doInBackground(String... params) {
        try {

            URL url = new URL("http://pout.ddns.net/messagerie/user/add.php?" +
                             "nom=" + this.user.getNom() +
                            "&prenom=" + this.user.getPrenom() +
                            "&email=" + this.user.getEmail() +
                            "&password=" + this.user.getPassword());
            URLConnection con =  url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(con.getInputStream()));
            return Tools.getStringFromBufferedReader(bfr);
            // Log.d("http", Tools.getStringFromBufferedReader(bfr));

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    //le parametre de la methode onPostExecute et initilaser par lea valeur retournee par doInBackground
    protected void onPostExecute(String s) {
        // super.onPostExecute(s);
        Log.d("HTTP", s);
    }
}
