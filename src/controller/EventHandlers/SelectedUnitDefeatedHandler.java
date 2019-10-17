package controller.EventHandlers;

import controller.GameController;

import java.beans.PropertyChangeEvent;

public class SelectedUnitDefeatedHandler extends AbstractEventHandler {

    public SelectedUnitDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
