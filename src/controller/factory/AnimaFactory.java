package controller.factory;

import model.items.Anima;
import model.items.IEquipableItem;


/**
 * This class is in charge of generating Animas.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class AnimaFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem anima = new Anima(setting + " Anima", power, minRange, maxRange);
        anima.setOwner(owner);
        return anima;
    }
}
