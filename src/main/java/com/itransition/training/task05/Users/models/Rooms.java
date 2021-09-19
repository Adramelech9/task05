package com.itransition.training.task05.Users.models;

import javax.persistence.*;

@Entity
@Table
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String setOfMoves;
    private String author;
    private boolean isFreeRoom;
    private String authorId;

    public Rooms(String setOfMoves, String author, String authorId) {
        this.setOfMoves = setOfMoves;
        this.author = author;
        this.isFreeRoom = true;
        this.authorId = authorId;
    }

    public Rooms() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSetOfMoves() {
        return setOfMoves;
    }

    public void setSetOfMoves(String setOfMoves) {
        this.setOfMoves = setOfMoves;
    }

    public boolean isFreeRoom() {
        return isFreeRoom;
    }

    public void setFreeRoom(boolean freeRoom) {
        isFreeRoom = freeRoom;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
