package controller.eventHandlers;

import controller.GameController;

import java.beans.PropertyChangeListener;

/**
 * This class represents an abstract event handler.
 * <p>
 * An abstract event handler is an event handler that cannot be used directly,
 * but contains the controller that its concrete subclasses will use
 * @author Agustin Matthey
 * @since 1.0
 */

public abstract class AbstractEventHandler implements PropertyChangeListener {
    GameController controller;

    public AbstractEventHandler(GameController controller){
        this.controller=controller;
    }
}
