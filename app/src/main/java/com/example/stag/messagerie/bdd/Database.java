package com.example.stag.messagerie.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by stag on 22/07/2016.
 */
public class Database {
    private final int BDD_VERSION = 1;
    private final String BDD_NAME = "messagerie.db";

    private DatabaseHelper maBdd;
    private SQLiteDatabase bdd;

    public Database(Context context){
        this.maBdd = new DatabaseHelper(context,BDD_NAME,null,BDD_VERSION);
    }

    public void open(){
        this.bdd = maBdd.getWritableDatabase();
    }

    public void close(){
        this.maBdd.close();
    }

    /**
     * Insertion des utilisateurs
     * @param u
     * @return
     */
    public long insertUser(User u) {
        ContentValues cv_user = new ContentValues();
        cv_user.put("nom", u.getNom());
        cv_user.put("prenom", u.getPrenom());
        cv_user.put("email", u.getEmail());
        cv_user.put("password", u.getPassword());
        return this.bdd.insert("user", null, cv_user);
    }

    /**
     * Update user
     * @param u
     * @return
     */
    public long updateUser(User u) {
        ContentValues cv_user = new ContentValues();
        cv_user.put("nom", u.getNom());
        cv_user.put("prenom", u.getPrenom());
        cv_user.put("email", u.getEmail());
        cv_user.put("password", u.getPassword());
        return this.bdd.update("user", cv_user, "id=?", new String[] {String.valueOf(u.getId())});
    }

    public long insertConversation (Conversation c) {
        ContentValues cv_conversation = new ContentValues();
        cv_conversation.put("user_one", c.getUser_one().getId());
        cv_conversation.put("user_two", c.getUser_two().getId());
        return this.bdd.insert("conversation", null, cv_conversation);
    }

    public long insertMessage(Message m) {
        ContentValues cv_message = new ContentValues();
        cv_message.put("sender", m.getSender().getId());
        cv_message.put("conversation", m.getConversation().getId());
        return this.bdd.insert("message", null, cv_message);
    }
}