package com.example.stag.messagerie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stag.messagerie.bdd.Database;
import com.example.stag.messagerie.bdd.HttpAsyncTask;
import com.example.stag.messagerie.bdd.User;

public class InscriptionActivity extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private Button btnValider;
    private Button btnInitialiser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        email =  (EditText)  findViewById(R.id.email);
        password =  (EditText)  findViewById(R.id.password);
        confirmPassword = (EditText)  findViewById(R.id.confirmPassword);
        btnValider = (Button)  findViewById(R.id.btnValider);
        btnInitialiser =  (Button) findViewById(R.id.btnInitialiser);

        //bouton valider
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user =  new User();
                user.setNom(nom.getText().toString());
                user.setPrenom(prenom.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());

                Database madbb = new Database(getApplicationContext());

                madbb.open();
                madbb.insertUser(user);
                madbb.close();

                HttpAsyncTask httptask =  new HttpAsyncTask(user);
                httptask.execute("");
            }
        });

        //bouton reset
        btnInitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }


}
