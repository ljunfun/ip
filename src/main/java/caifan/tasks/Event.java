package caifan.tasks;

/**
 * Represents a task that has a start and end time/date.
 * This class extends Task to include event-specific timing information.
 */
public class Event extends Task {

    protected String start;
    protected String end;

    /**
     * Creates a new event task with the specified description and timing.
     *
     * @param description The description of the event
     * @param start The start time/date of the event
     * @param end The end time/date of the event
     */
    public Event (String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the type identifier for the event task.
     *
     * @return The type identifier "E" for event tasks
     */
    public String getType() {
        return "E";
    }

    /**
     * Gets the start time/date of the event.
     *
     * @return The start time/date as a string
     */
    public String getStart() {
        return this.start;
    }

    /**
     * Gets the end time/date of the event.
     *
     * @return The end time/date as a string
     */
    public String getEnd() {
        return this.end;
    }

    /**
     * Returns a string representation of the event task.
     * Includes the task type, completion status, description, and timing information.
     *
     * @return The formatted string representation of the event
     */
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}
