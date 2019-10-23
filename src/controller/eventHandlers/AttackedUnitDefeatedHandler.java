package controller.eventHandlers;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
/**
 * This class represents an event handler.
 * <p>
 * This event handler acts in response to the death of an attacked unit.
 * @author Agustin Matthey
 * @since 1.0
 */
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
