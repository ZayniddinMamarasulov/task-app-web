package com.example.task_app_web;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

//@Getter
//@Setter
@Data
@FieldNameConstants
public class Task {

    private Long id;

    private String title;

    private String description;

    private int priority;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
