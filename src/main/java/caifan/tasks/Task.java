package caifan.tasks;

/**
 * Reads the next line of input from the user.
 * @return The command string entered by the user
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a new task with the specified description.
     * @param description The description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the description of the task.
     * @return The description of the task
     */
    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return "";
    }

    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Gets the status icon of the task.
     * @return The status icon ("X" for done, " " for not done)
     */
    public String getStatusIcon() {
        return (isDone ? "✓" : " ");
    }

    /**
     * Marks the task as done or not done.
     */
    public void setDone(boolean status) {
        isDone = status;
    }

    /**
     * Gets the description of the task.
     * @return The description of the task
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
