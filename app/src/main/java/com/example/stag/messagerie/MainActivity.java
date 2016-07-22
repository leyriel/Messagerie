package com.example.stag.messagerie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by eric on 22/07/2016.
 */
public class MainActivity extends AppCompatActivity {

    private Button startConversButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Session session = new Session(getApplicationContext());
        session.saveSessionState(true);
        Log.d("SESSION_STATE", Boolean.toString(session.getSessionState()));

        if(Boolean.toString(session.getSessionState())){
            setContentView(R.layout.activity_conversation);
        }else{
            setContentView(R.layout.activity_main);
        }

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

            }
        });
    }
}
