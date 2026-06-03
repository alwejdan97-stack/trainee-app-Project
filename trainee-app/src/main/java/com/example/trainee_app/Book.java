package com.example.trainee_app;

public class Book {
    private int ID;
    private String name;
    private int authorId;

    public Book(int ID, String name, int authorId) {
        this.ID = ID;
        this.name = name;
        this.authorId = authorId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
