package co.com.sofka.crud.model.dto;

import javax.validation.constraints.NotNull;

public class ActivityRequestDTO {
    @NotNull(message = "The name property is required")
    private String name;

    @NotNull(message = "The completed property is required")
    private boolean completed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
