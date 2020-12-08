package com.sheepapps.bondar.beans;

import java.io.Serializable;
import java.util.Objects;

public class Board implements Serializable, Comparable {

    private String name;
    private String projectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return name.equals(board.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Board board = (Board) o;
        return this.name.compareTo(board.name);
    }
}
