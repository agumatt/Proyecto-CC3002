package controller.eventHandlers;

import controller.GameController;
import model.Tactician;

import java.beans.PropertyChangeEvent;

public class PlayerDefeatedHandler extends AbstractEventHandler{
    /**
     * This class represents an event handler.
     * <p>
     * This event handler acts in response to a player being defeated, either by
     * the death of a hero unit or the loss of all his units.
     * @author Agustin Matthey
     * @since 1.0
     */

    public PlayerDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("player defeated")){
            controller.removeTactician(((Tactician) evt.getOldValue()).getName());
        }

    }
}
