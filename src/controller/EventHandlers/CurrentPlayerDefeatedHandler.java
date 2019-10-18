package controller.EventHandlers;

import controller.GameController;
import model.Tactician;

import java.beans.PropertyChangeEvent;

public class CurrentPlayerDefeatedHandler extends AbstractEventHandler{


    public CurrentPlayerDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("current player defeated")){
            controller.removeTactician(((Tactician) evt.getOldValue()).getName());
            controller.endTurn();
        }

    }
}
