package controller.eventHandlers;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;

public class SelectedUnitDefeatedHandler extends AbstractEventHandler {

    /**
     * This class represents an event handler.
     * <p>
     * This event handler acts in response to the death of the attacking unit.
     * @author Agustin Matthey
     * @since 1.0
     */
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
