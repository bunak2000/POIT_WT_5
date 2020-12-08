package com.sheepapps.bondar.presentation.console;

import io.reactivex.subjects.BehaviorSubject;

public interface IConsoleController {
    void start(boolean showMenu);
    BehaviorSubject<String> getRenderState();
}
