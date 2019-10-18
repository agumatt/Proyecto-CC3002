package controller.EventHandlers;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;

public class AttackedUnitDefeatedHandler extends AbstractEventHandler{

    public AttackedUnitDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("attacked unit defeated")){
             controller.removeUnit((IUnit)evt.getOldValue());
        }

    }
}
