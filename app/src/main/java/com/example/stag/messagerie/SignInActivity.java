package com.example.stag.messagerie;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by eric on 22/07/2016.
 */
public class SignInActivity extends AppCompatActivity {

    private Button signInButton;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailField    = (EditText)findViewById(R.id.fieldEmail);
        passwordField = (EditText)findViewById(R.id.fieldPassword);
        signInButton  = (Button)findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("EVT", emailField.getText().toString());
                Log.d("EVT", passwordField.getText().toString());
            }
        });
    }
}
