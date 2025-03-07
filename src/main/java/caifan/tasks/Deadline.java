package caifan.tasks;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {

    protected String deadline;

    /**
     * Creates a new deadline task with the specified description and deadline.
     * @param description The description of the task
     * @param deadline The deadline of the task
     */
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Gets the type of the task.
     * @return The type of the task ("D" for deadline)
     */
    public String getType() {
        return "D";
    }

    /**
     * Gets the deadline of the task.
     * @return The deadline of the task
     */
    public String getDeadline() {
        return this.deadline;
    }

    /**
     * Returns the string representation of the task.
     * @return The string representation of the task
     */
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}

