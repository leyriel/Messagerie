package com.example.stag.messagerie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startConversButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startConversButton = (Button)findViewById(R.id.startButton);
        registerButton     = (Button)findViewById(R.id.registerButton);

        startConversButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startConversActivity = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(startConversActivity);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_inscription = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent_inscription);
            }
        });
    }
}
