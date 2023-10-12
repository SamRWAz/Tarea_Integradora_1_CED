package model;

public class Action {

    private String actionType;
    private Task taskDetails;
    private int id;

    public Action(String actionType, Task taskDetails, int id) {
        this.actionType = actionType;
        this.taskDetails = taskDetails;
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Task getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(Task taskDetails) {
        this.taskDetails = taskDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
}
