package caifan.tasks;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return "";
    }

    public boolean isDone() {
        return this.isDone;
    }

    // mark done task with ✓
    public String getStatusIcon() {
        return (isDone ? "✓" : " ");
    }

    //change the status of current task
    public void setDone(boolean status) {
        isDone = status;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
