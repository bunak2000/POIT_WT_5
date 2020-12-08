package com.sheepapps.bondar.beans;

import java.io.Serializable;
import java.util.Objects;

public class Project implements Serializable, Comparable {

    private String name;
    private String deadline;
    private String companyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return name.equals(project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Project project = (Project) o;
        return this.name.compareTo(project.name);
    }

}
