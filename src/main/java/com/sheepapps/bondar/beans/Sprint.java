package com.sheepapps.bondar.beans;

import java.io.Serializable;
import java.util.Objects;

public class Sprint implements Serializable, Comparable {

    private String name;
    private String boardId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return name.equals(sprint.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "name='" + name + '\'' +
                ", boardId='" + boardId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Sprint sprint = (Sprint) o;
        return this.name.compareTo(sprint.name);
    }

}
