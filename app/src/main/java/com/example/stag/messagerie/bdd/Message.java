package com.example.stag.messagerie.bdd;

/**
 * Created by stag on 22/07/2016.
 */
public class Message {
    private int id;
    /**
     * Utilisateur du message
     */
    private User sender;

    /**
     * conversation du message
     *
     */
    private Conversation conversation;

    /**
     *
     * message
     */
    private String message;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
