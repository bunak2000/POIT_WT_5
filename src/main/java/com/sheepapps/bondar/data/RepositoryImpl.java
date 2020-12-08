package com.sheepapps.bondar.data;

import com.sheepapps.bondar.beans.Board;
import com.sheepapps.bondar.beans.Company;
import com.sheepapps.bondar.beans.Developer;
import com.sheepapps.bondar.beans.Project;
import com.sheepapps.bondar.beans.Sprint;
import com.sheepapps.bondar.beans.Task;
import com.sheepapps.bondar.presentation.abstraction.IRepository;

import java.util.ArrayList;

public class RepositoryImpl implements IRepository {

    private IStorageDataSource storageDataSource;
    private ICacheDataSource cacheDataSource;

    public RepositoryImpl(IStorageDataSource storageDataSource, ICacheDataSource cacheDataSource) {
        this.storageDataSource = storageDataSource;
        this.cacheDataSource = cacheDataSource;
    }

    @Override
    public void loadData() {
        DataModel model = storageDataSource.getDataModel();
        if (model == null) {
            model = new DataModel();
        }
        cacheDataSource.setDataModel(model);
    }

    @Override
    public ArrayList<Company> getCompanies() {
        return cacheDataSource.getDataModel().getCompanies();
    }

    @Override
    public boolean createCompany(Company company) {
        if (!companyExists(company.getName())) {
            cacheDataSource.getDataModel().getCompanies().add(company);
            storageDataSource.saveDataModel(cacheDataSource.getDataModel());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCompany(String companyId) {
        ArrayList<Company> companies = cacheDataSource.getDataModel().getCompanies();
        return companies.removeIf(company -> company.getName().equals(companyId));
    }

    @Override
    public boolean companyExists(String companyId) {
        ArrayList<Company> companies = cacheDataSource.getDataModel().getCompanies();
        for (Company company : companies) {
            if (company.getName().equals(companyId)) return true;
        }
        return false;
    }

    @Override
    public void editCompany(String companyId, Company company) {
        deleteCompany(companyId);
        createCompany(company);
    }

    @Override
    public ArrayList<Project> getProjects() {
        return cacheDataSource.getDataModel().getProjects();
    }

    @Override
    public boolean createProject(Project project) {
        if (!projectExists(project.getName())) {
            cacheDataSource.getDataModel().getProjects().add(project);
            storageDataSource.saveDataModel(cacheDataSource.getDataModel());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProject(String projectId) {
        ArrayList<Project> projects = cacheDataSource.getDataModel().getProjects();
        return projects.removeIf(project -> project.getName().equals(projectId));
    }

    @Override
    public boolean projectExists(String projectId) {
        ArrayList<Project> projects = cacheDataSource.getDataModel().getProjects();
        for (Project project : projects) {
            if (project.getName().equals(projectId)) return true;
        }
        return false;
    }

    @Override
    public void editProject(String projectId, Project project) {
        deleteProject(projectId);
        createProject(project);
    }

    @Override
    public ArrayList<Board> getBoards() {
        return cacheDataSource.getDataModel().getBoards();
    }

    @Override
    public boolean createBoard(Board board) {
        if (!boardExists(board.getName())) {
            cacheDataSource.getDataModel().getBoards().add(board);
            storageDataSource.saveDataModel(cacheDataSource.getDataModel());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteBoard(String boardId) {
        ArrayList<Board> boards = cacheDataSource.getDataModel().getBoards();
        return boards.removeIf(board -> board.getName().equals(boardId));
    }

    @Override
    public boolean boardExists(String boardId) {
        ArrayList<Board> boards = cacheDataSource.getDataModel().getBoards();
        for (Board board : boards) {
            if (board.getName().equals(boardId)) return true;
        }
        return false;
    }

    @Override
    public void editBoard(String boardId, Board board) {
        deleteBoard(boardId);
        createBoard(board);
    }

    @Override
    public ArrayList<Sprint> getSprints() {
        return cacheDataSource.getDataModel().getSprints();
    }

    @Override
    public boolean createSprint(Sprint sprint) {
        if (!sprintExists(sprint.getName())) {
            cacheDataSource.getDataModel().getSprints().add(sprint);
            storageDataSource.saveDataModel(cacheDataSource.getDataModel());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteSprint(String sprintId) {
        ArrayList<Sprint> sprints = cacheDataSource.getDataModel().getSprints();
        return sprints.removeIf(sprint -> sprint.getName().equals(sprintId));
    }

    @Override
    public boolean sprintExists(String sprintId) {
        ArrayList<Sprint> sprints = cacheDataSource.getDataModel().getSprints();
        for (Sprint sprint : sprints) {
            if (sprint.getName().equals(sprintId)) return true;
        }
        return false;
    }

    @Override
    public void editSprint(String sprintId, Sprint sprint) {
        deleteSprint(sprintId);
        createSprint(sprint);
    }

    @Override
    public ArrayList<Developer> getDevelopers() {
        return cacheDataSource.getDataModel().getDevelopers();
    }

    @Override
    public boolean createDeveloper(Developer developer) {
        if (!developerExists(developer.getName())) {
            cacheDataSource.getDataModel().getDevelopers().add(developer);
            storageDataSource.saveDataModel(cacheDataSource.getDataModel());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteDeveloper(String developerId) {
        ArrayList<Developer> developers = cacheDataSource.getDataModel().getDevelopers();
        return developers.removeIf(developer -> developer.getName().equals(developerId));
    }

    @Override
    public boolean developerExists(String developerId) {
        ArrayList<Developer> developers = cacheDataSource.getDataModel().getDevelopers();
        for (Developer developer : developers) {
            if (developer.getName().equals(developerId)) return true;
        }
        return false;
    }

    @Override
    public void editDeveloper(String developerId, Developer developer) {
        deleteDeveloper(developerId);
        createDeveloper(developer);
    }

    @Override
    public ArrayList<Task> getTasks() {
        return cacheDataSource.getDataModel().getTasks();
    }

    @Override
    public boolean createTask(Task task) {
        if (!taskExists(task.getName())) {
            cacheDataSource.getDataModel().getTasks().add(task);
            storageDataSource.saveDataModel(cacheDataSource.getDataModel());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteTask(String taskId) {
        ArrayList<Task> tasks = cacheDataSource.getDataModel().getTasks();
        return tasks.removeIf(task -> task.getName().equals(taskId));
    }

    @Override
    public boolean taskExists(String taskId) {
        ArrayList<Task> tasks = cacheDataSource.getDataModel().getTasks();
        for (Task task : tasks) {
            if (task.getName().equals(taskId)) return true;
        }
        return false;
    }

    @Override
    public void editTask(String taskId, Task task) {
        deleteTask(taskId);
        createTask(task);
    }


}
