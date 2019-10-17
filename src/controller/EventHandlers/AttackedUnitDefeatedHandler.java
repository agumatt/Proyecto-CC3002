package controller.EventHandlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;

public class AttackedUnitDefeatedHandler extends AbstractEventHandler{

    public AttackedUnitDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
