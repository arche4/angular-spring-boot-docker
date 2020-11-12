package co.com.sofka.crud.model.dto;

import javax.validation.constraints.NotNull;

public class ActivityUpdateRequest  {

    @NotNull(message = "The idActivity property is required")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}