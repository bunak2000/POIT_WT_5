package com.sheepapps.bondar.presentation.console;

import com.sheepapps.bondar.beans.Company;
import com.sheepapps.bondar.beans.Task;
import com.sheepapps.bondar.di.DependencyInjection;
import com.sheepapps.bondar.presentation.abstraction.IRepository;
import java.util.ArrayList;
import java.util.Scanner;
import io.reactivex.subjects.BehaviorSubject;

public class ConsoleControllerImpl implements IConsoleController {

    private IRepository repository = DependencyInjection.getRepository();
    private Scanner scanner = new Scanner(System.in);

    private BehaviorSubject<String> renderState = BehaviorSubject.create();


    @Override
    public void start(boolean showMenu) {
        repository.loadData();
        if (showMenu) {
            String startMsg = "Выберете раздел: \n" +
                    "1) Компании.\n" +
                    "2) Доски.\n" +
                    "3) Разработчики.\n" +
                    "4) Проекты.\n" +
                    "5) Спринты.\n" +
                    "6) Задачи.";
            renderState.onNext(startMsg);
        }
        startCommand(readLineFromConsole());
    }

    private void startCommand(String command) {
        switch (command) {
            case "1":
                String msg = "Выберете действие: \n" +
                        "1) Добавить компанию.\n" +
                        "2) Удалить компанию.\n" +
                        "3) Редактировать компанию.\n" +
                        "4) Список компаний.\n" +
                        "5) Главное меню.";
                renderState.onNext(msg);
                companyCommand(readLineFromConsole());
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                msg = "Выберете действие: \n" +
                        "1) Добавить задачу.\n" +
                        "2) Удалить задачу.\n" +
                        "3) Редактировать задачу.\n" +
                        "4) Список задач.\n" +
                        "5) Главное меню.";
                renderState.onNext(msg);
                taskCommand(readLineFromConsole());
                break;
            default:
                printError("Введите цифру от 1 до 6.");
                start(false);
                break;

        }
    }

    private void companyCommand(String command) {
        switch (command) {
            case "1":
                createCompany();
                break;
            case "2":
                deleteCompany();
                break;
            case "3":
                editCompany();
                break;
            case "4":
                printCompanies();
                break;
            case "5":
                start(true);
                break;
            default:
                printError("Введите цифру от 1 до 5.");
                startCommand("1");
                break;

        }
    }

    private Company createCompanyObj() {
        Company company = new Company();
        renderState.onNext("Введите имя компании: ");
        company.setName(readLineFromConsole());
        renderState.onNext("Введите УНП компании: ");
        company.setTaxNumber(readLineFromConsole());
        return company;
    }

    private void createCompany() {
        boolean result = repository.createCompany(createCompanyObj());
        if (result) {
            renderState.onNext("Компания успешно создана!");
        } else {
            printError("Такая компания уже существует.");
        }
        startCommand("1");
    }

    private void deleteCompany() {
        ArrayList<Company> companies = repository.getCompanies();
        ArrayList<String> names = new ArrayList<>();
        for (Company company : companies) {
            names.add(company.getName());
        }
        printListWithNumbers(names);
        renderState.onNext("Компания: ");
        boolean result = repository.deleteCompany(readLineFromConsole());
        if (result) {
            renderState.onNext("Компания успешно удалена!");
        } else {
            printError("Такой компании не существует.");
        }
        startCommand("1");
    }

    private void editCompany() {
        ArrayList<Company> companies = repository.getCompanies();
        ArrayList<String> names = new ArrayList<>();
        for (Company company : companies) {
            names.add(company.getName());
        }
        printListWithNumbers(names);
        renderState.onNext("Компания: ");
        String companyToEdit = readLineFromConsole();
        boolean result = repository.companyExists(companyToEdit);
        if (result) {
            Company company = createCompanyObj();
            repository.editCompany(companyToEdit, company);
            renderState.onNext("Компания успешно отредактирована!");
        } else {
            renderState.onNext("Такой компании не существует!");
        }
        startCommand("1");
    }

    private void printCompanies() {
        ArrayList<Company> companies = repository.getCompanies();
        for (Company company : companies) {
            renderState.onNext(company.toString());
        }
        renderState.onNext("____________________");
        startCommand("1");
    }

    private void taskCommand(String command) {
        switch (command) {
            case "1":
                createTask();
                break;
            case "2":
                deleteTask();
                break;
            case "3":
                editTask();
                break;
            case "4":
                printTasks();
                break;
            case "5":
                start(true);
                break;
            default:
                printError("Введите цифру от 1 до 5.");
                startCommand("6");
                break;

        }
    }

    private Task createTaskObj() {
        Task task = new Task();
        renderState.onNext("Введите название задачи: ");
        task.setName(readLineFromConsole());
        renderState.onNext("Введите описание задачи: ");
        task.setDescription(readLineFromConsole());
        renderState.onNext("Введите название спринта: ");
        task.setSprintId(readLineFromConsole());
        renderState.onNext("Введите имя разработчика: ");
        task.setDeveloperId(readLineFromConsole());
        return task;
    }

    private void createTask() {
        boolean result = repository.createTask(createTaskObj());
        if (result) {
            renderState.onNext("Задача успешно создана!");
        } else {
            printError("Такая задача уже существует.");
        }
        startCommand("6");
    }

    private void deleteTask() {
        ArrayList<Task> tasks = repository.getTasks();
        ArrayList<String> names = new ArrayList<>();
        for (Task task : tasks) {
            names.add(task.getName());
        }
        printListWithNumbers(names);
        renderState.onNext("Задача: ");
        boolean result = repository.deleteCompany(readLineFromConsole());
        if (result) {
            renderState.onNext("Задача успешно удалена!");
        } else {
            printError("Такой задачи не существует.");
        }
        startCommand("6");
    }

    private void editTask() {
        ArrayList<Task> tasks = repository.getTasks();
        ArrayList<String> names = new ArrayList<>();
        for (Task task : tasks) {
            names.add(task.getName());
        }
        printListWithNumbers(names);
        renderState.onNext("Задача: ");
        String taskToEdit = readLineFromConsole();
        boolean result = repository.taskExists(taskToEdit);
        if (result) {
            Task task = createTaskObj();
            repository.editTask(taskToEdit, task);
            renderState.onNext("Задача успешно отредактирована!");
        } else {
            renderState.onNext("Такой задачи не существует!");
        }
        startCommand("6");
    }

    private void printTasks() {
        ArrayList<Task> tasks = repository.getTasks();
        for (Task task : tasks) {
            renderState.onNext(task.toString());
        }
        renderState.onNext("____________________");
        startCommand("6");
    }

    private void boardCommand(String command) {
        switch (command) {
            case "1":
                createCompany();
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                System.out.println("6");
                break;
            default:
                printError("Введите цифру от 1 до 6.");
                start(false);
                break;

        }
    }

    private void developerCommand(String command) {
        switch (command) {
            case "1":
                createCompany();
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                System.out.println("6");
                break;
            default:
                printError("Введите цифру от 1 до 6.");
                start(false);
                break;

        }
    }

    private void projectCommand(String command) {
        switch (command) {
            case "1":
                createCompany();
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                System.out.println("6");
                break;
            default:
                printError("Введите цифру от 1 до 6.");
                start(false);
                break;

        }
    }

    private void sprintCommand(String command) {
        switch (command) {
            case "1":
                createCompany();
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                System.out.println("6");
                break;
            default:
                printError("Введите цифру от 1 до 6.");
                start(false);
                break;

        }
    }

    private void printError(String text) {
        String errorMsg = "Ошибка! " + text;
        renderState.onNext(errorMsg);
    }

    private String readLineFromConsole() {
        return scanner.nextLine();
    }

    private void printListWithNumbers(ArrayList<String> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + ") " + list.get(i - 1));
        }
    }

    @Override
    public BehaviorSubject<String> getRenderState() {
        return renderState;
    }

}
