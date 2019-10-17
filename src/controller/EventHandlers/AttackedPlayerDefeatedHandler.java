package controller.EventHandlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;

public class AttackedPlayerDefeatedHandler extends AbstractEventHandler{

    public AttackedPlayerDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
