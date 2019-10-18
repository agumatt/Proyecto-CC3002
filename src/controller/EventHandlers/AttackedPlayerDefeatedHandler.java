package controller.EventHandlers;

import controller.GameController;
import model.Tactician;

import java.beans.PropertyChangeEvent;

public class AttackedPlayerDefeatedHandler extends AbstractEventHandler{

    public AttackedPlayerDefeatedHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("attacked player defeated")){
            controller.removeTactician(((Tactician)evt.getOldValue()).getName());
            if(controller.getTacticians().size()==1){
                controller.endTurn();           //solo queda el jugador en turno
            }
        }

    }
}
