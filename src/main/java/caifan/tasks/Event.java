package caifan.tasks;

public class Event extends Task {

    protected String start;
    protected String end;

    public Event (String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    public String getType() {
        return "E";
    }

    public String getStart() {
        return this.start;
    }

    public String getEnd() {
        return this.end;
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}
