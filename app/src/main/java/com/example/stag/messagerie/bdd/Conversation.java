package com.example.stag.messagerie.bdd;

/**
 * Created by stag on 22/07/2016.
 */
public class Conversation {
    private int id;
    private User user_one;
    private User user_two;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_one() {
        return user_one;
    }

    public void setUser_one(User user_one) {
        this.user_one = user_one;
    }

    public User getUser_two() {
        return user_two;
    }

    public void setUser_two(User user_two) {
        this.user_two = user_two;
    }
}
