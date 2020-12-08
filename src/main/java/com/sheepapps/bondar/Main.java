package com.sheepapps.bondar;

import com.sheepapps.bondar.presentation.console.ConsoleControllerImpl;
import com.sheepapps.bondar.presentation.console.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        view.setConsoleViewController(new ConsoleControllerImpl());
        view.start();
    }
}
