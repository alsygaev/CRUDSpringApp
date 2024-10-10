package ru.education.spring.course.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Notation {
    private int id;

    @NotEmpty(message = "Напоминание не может быть пустым")
    @Size(min = 5, max = 30, message = "Напоминание должно быть от 5 до 30 букв")
    private String description;

    @NotEmpty(message = "Время напоминания не может быть пустым")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "Время нужно указать в формате hh:mm")
    private String time;

    public Notation() {
    }

    public Notation(int id, String description, String time) {
        this.id = id;
        this.description = description;
        this.time = time;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
