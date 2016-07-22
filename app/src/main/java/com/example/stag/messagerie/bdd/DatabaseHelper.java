package com.example.stag.messagerie.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stag on 22/07/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "nom TEXT, " +
                                        "prenom TEXT, " +
                                        "email TEXT, " +
                                        "password TEXT" + ")");

        db.execSQL("CREATE TABLE conversation (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_user1 INTEGER REFERENCES user(id), " +
                "id_user2 INTEGER REFERENCES user(id)" + ")");

        db.execSQL("CREATE TABLE message (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_conversation INTEGER REFERENCES conversation(id), " +
                "id_sender INTEGER REFERENCES user(id)" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE user");
        db.execSQL("DROP TABLE conversation");
        db.execSQL("DROP TABLE message");
        onCreate(db);
    }
}
