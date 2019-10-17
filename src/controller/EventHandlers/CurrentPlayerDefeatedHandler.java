package controller.EventHandlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;

public class CurrentPlayerDefeatedHandler extends AbstractEventHandler{


    public CurrentPlayerDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
