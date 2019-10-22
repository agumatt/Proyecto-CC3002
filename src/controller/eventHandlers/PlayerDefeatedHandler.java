package controller.eventHandlers;

import controller.GameController;
import model.Tactician;

import java.beans.PropertyChangeEvent;

public class PlayerDefeatedHandler extends AbstractEventHandler{


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
