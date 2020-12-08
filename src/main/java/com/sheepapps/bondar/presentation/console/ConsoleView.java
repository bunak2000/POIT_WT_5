package com.sheepapps.bondar.presentation.console;

import io.reactivex.disposables.Disposable;

public class ConsoleView {

    private IConsoleController controller;

    private Disposable disposable;

    public void setConsoleViewController(IConsoleController controller) {
        this.controller = controller;
    }

    public void start() {
        disposable = controller.getRenderState().subscribe(this::printToConsole);
        controller.start(true);
    }

    private void printToConsole(String string) {
        System.out.println(string);
    }

    public void dispose() {
        disposable.dispose();
    }

}
