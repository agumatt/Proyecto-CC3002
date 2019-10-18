package controller.EventHandlers;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;

public class SelectedUnitDefeatedHandler extends AbstractEventHandler {

    public SelectedUnitDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("selected unit defeated")){
            controller.removeUnit((IUnit)evt.getOldValue());
        }

    }
}
