package com.sheepapps.bondar.beans;

import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable, Comparable {

    private String name;
    private String description;
    private String sprintId;
    private String developerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sprintId='" + sprintId + '\'' +
                ", developerId='" + developerId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Task task = (Task) o;
        return this.name.compareTo(task.name);
    }

}
