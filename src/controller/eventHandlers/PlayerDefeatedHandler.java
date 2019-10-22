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
        System.out.println("property triggered");
        if(evt.getPropertyName().equals("current player defeated") || evt.getPropertyName().equals("attacked player defeated")){
            controller.removeTactician(((Tactician) evt.getOldValue()).getName());
            System.out.println("change executed");
        }

    }
}
