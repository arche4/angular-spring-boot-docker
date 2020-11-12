package co.com.sofka.crud.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ListTodo {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name", nullable = false, length=70)
    private String name;
    @Column(name="description_list")
    private String description_list;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "listTodo",
            cascade = CascadeType.ALL
    )
    private List<Activity> activity = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }
}
