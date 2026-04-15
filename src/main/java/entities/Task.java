package entities;

import exceptions.InvalidDescription;

public class Task {

    private final String description;
    private boolean completed;

    //region constructors

    public Task(String description) {
        if (description == null || description.isBlank()) {
            throw new InvalidDescription("Description cannot be empty.");
        }
        this.description = description;
    }

    //endregion

    //region getters and setters

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (isCompleted() ? "[x] " : "[ ] ") + description;
    }

    //endregion

}