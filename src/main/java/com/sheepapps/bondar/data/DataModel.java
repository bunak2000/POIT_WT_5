package com.sheepapps.bondar.data;

import com.sheepapps.bondar.beans.Board;
import com.sheepapps.bondar.beans.Company;
import com.sheepapps.bondar.beans.Developer;
import com.sheepapps.bondar.beans.Project;
import com.sheepapps.bondar.beans.Sprint;
import com.sheepapps.bondar.beans.Task;
import java.io.Serializable;
import java.util.ArrayList;

public class DataModel implements Serializable {

    private ArrayList<Board> boards = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();
    private ArrayList<Developer> developers = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Sprint> sprints = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void setBoards(ArrayList<Board> boards) {
        this.boards = boards;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public ArrayList<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(ArrayList<Developer> developers) {
        this.developers = developers;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(ArrayList<Sprint> sprints) {
        this.sprints = sprints;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

}
