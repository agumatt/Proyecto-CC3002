package controller.factory;

import model.items.Bow;
import model.items.IEquipableItem;

/**
 * This class is in charge of generating Bow.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */

public class BowFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem bow = new Bow(setting + " Bow", power, minRange, maxRange);
        bow.setOwner(owner);
        return bow;
    }
}
