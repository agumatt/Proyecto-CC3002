package controller.EventHandlers;

import controller.GameController;

import java.beans.PropertyChangeListener;

public abstract class AbstractEventHandler implements PropertyChangeListener {
    GameController controller;

    public AbstractEventHandler(GameController controller){
        this.controller=controller;
    }
}
