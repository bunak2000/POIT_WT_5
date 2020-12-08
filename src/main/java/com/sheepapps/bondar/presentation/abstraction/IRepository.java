package com.sheepapps.bondar.presentation.abstraction;

import com.sheepapps.bondar.beans.Board;
import com.sheepapps.bondar.beans.Company;
import com.sheepapps.bondar.beans.Developer;
import com.sheepapps.bondar.beans.Project;
import com.sheepapps.bondar.beans.Sprint;
import com.sheepapps.bondar.beans.Task;

import java.util.ArrayList;

public interface IRepository {

    void loadData();

    ArrayList<Company> getCompanies();
    boolean createCompany(Company company);
    boolean deleteCompany(String companyId);
    boolean companyExists(String companyId);
    void editCompany(String companyId, Company company);

    ArrayList<Project> getProjects();
    boolean createProject(Project project);
    boolean deleteProject(String projectId);
    boolean projectExists(String projectId);
    void editProject(String projectId, Project project);

    ArrayList<Board> getBoards();
    boolean createBoard(Board board);
    boolean deleteBoard(String boardId);
    boolean boardExists(String boardId);
    void editBoard(String boardId, Board board);

    ArrayList<Sprint> getSprints();
    boolean createSprint(Sprint sprint);
    boolean deleteSprint(String sprintId);
    boolean sprintExists(String sprintId);
    void editSprint(String sprintId, Sprint sprint);

    ArrayList<Developer> getDevelopers();
    boolean createDeveloper(Developer developer);
    boolean deleteDeveloper(String developerId);
    boolean developerExists(String developerId);
    void editDeveloper(String developerId, Developer developer);

    ArrayList<Task> getTasks();
    boolean createTask(Task task);
    boolean deleteTask(String taskId);
    boolean taskExists(String taskId);
    void editTask(String taskId, Task task);

}
