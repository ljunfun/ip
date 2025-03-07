package caifan.tasks;

/**
 * Returns a string representation of the event task.
 * Includes the task type, completion status, description, and timing information.
 *
 * @return The formatted string representation of the event
 */
public class Todo extends Task {

    /**
     * Creates a new todo task with the specified description.
     *
     * @param description The description of the todo task
     */
    public Todo (String description) {
        super(description);
    }

    /**
     * Gets the type identifier for the todo task.
     *
     * @return The type identifier "T" for todo tasks
     */
    public String getType() {
        return "T";
    }

    /**
     * Returns a string representation of the todo task.
     * Includes the task type, completion status, and description.
     *
     * @return The formatted string representation of the todo task
     */
    public String toString () {
        return "[T]" + super.toString();
    }
}
