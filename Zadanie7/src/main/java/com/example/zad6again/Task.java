package com.example.zad6again;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task() {
        id = UUID.randomUUID();
        date = new Date();
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDate() {
        return this.date;
    }

    public boolean isDone() {
        return this.done;
    }

}