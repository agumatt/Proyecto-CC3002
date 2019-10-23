package controller.factory;

import model.items.IEquipableItem;
import model.items.Spear;

/**
 * This class is in charge of generating Spears.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class SpearFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem spear = new Spear(setting + " Spear", power, minRange, maxRange);
        spear.setOwner(owner);
        return spear;
    }
}
