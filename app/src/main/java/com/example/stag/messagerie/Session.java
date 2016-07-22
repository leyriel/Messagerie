package com.example.stag.messagerie;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by eric on 22/07/2016.
 */
public class Session {

    private Context context;
    private String KEY_CONTENT = "session";
    private SharedPreferences setting;

    public Session(Context _context) {
        this.context = _context;
        this.setting = this.context.getSharedPreferences("session", Context.MODE_PRIVATE);
    }

    public void saveSessionState(boolean sessionState){
        SharedPreferences.Editor editor = this.setting.edit();
        editor.putBoolean(KEY_CONTENT, sessionState);
        editor.apply();
    }

    public boolean getSessionState(){
        return this.setting.getBoolean(KEY_CONTENT, false);
    }
}
