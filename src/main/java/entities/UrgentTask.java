package entities;

import enums.ListOfPriority;

public class UrgentTask extends Task {

    private final ListOfPriority priority;

    public UrgentTask(String description) {
        super(description);
        priority = ListOfPriority.HIGH;
    }

    public ListOfPriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return (isCompleted() ? "[x] " : "[ ] ") + getDescription() + (" - This is a ") + getPriority() + (" priority task.");
    }

}
