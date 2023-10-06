package model;

public class Task {
    private String title;
    private String description;
    private String datelimit;
    private Priority priority;


    public Task(String title, String description, String datelimit, Priority priority) {

        this.title = title;
        this.description = description;
        this.datelimit = datelimit;
        this.priority = priority;
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


    public Priority getPriority() {
        return priority;
    }


    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Task [title=" + title + ", description=" + description + ", datelimit=" + datelimit
                + ", priority=" + priority + "]";
    }

    
    

    
}