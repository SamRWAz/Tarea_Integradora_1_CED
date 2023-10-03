package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String datelimit;
    private String priority;


    public Task(int id, String title, String description, String datelimit, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datelimit = datelimit;
        this.priority = priority;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDatelimit() {
        return datelimit;
    }


    public void setDatelimit(String datelimit) {
        this.datelimit = datelimit;
    }


    public String getPriority() {
        return priority;
    }


    public void setPriority(String priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", datelimit=" + datelimit
                + ", priority=" + priority + "]";
    }

    
    

    
}