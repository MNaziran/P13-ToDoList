package sg.edu.rp.c346.id20028828.to_dolist;

import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String name;
    private String description;
    private String date;
    private int importance;

    public Task(int id, String name, String description, String date, int importance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
