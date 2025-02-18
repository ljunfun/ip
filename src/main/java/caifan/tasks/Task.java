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

    // mark done task with ✓
    public String getStatusIcon() {
        return (isDone ? "✓" : " ");
    }

    //change the status of current task
    public void setDone(boolean status) {
        isDone = status;
    }

    public String getType() {
        return " ";
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
