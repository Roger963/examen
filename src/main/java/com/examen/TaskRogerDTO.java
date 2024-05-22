package com.examen;

import java.io.Serializable;



public class TaskRogerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer number;
    private Boolean active;
      
    public TaskRogerDTO() {
    }
    public TaskRogerDTO(Long id, String name, Integer number, Boolean active) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.active = active;
    }
    public TaskRogerDTO(TaskRoger entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.number = entity.getNumber();
        this.active = entity.getActive();
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
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

}
