package co.com.sofka.crud.model.dto;


import javax.validation.constraints.NotNull;

public class ListTodoRequestDTO {
    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "description_list is required")
    private String description_list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription_list() {
        return description_list;
    }

    public void setDescription_list(String description_list) {
        this.description_list = description_list;
    }



}
