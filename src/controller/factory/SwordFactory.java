package controller.factory;

import model.items.IEquipableItem;
import model.items.Sword;

/**
 * This class is in charge of generating Swords.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class SwordFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem sword = new Sword(setting + " Sword", power, minRange, maxRange);
        sword.setOwner(owner);
        return sword;
    }
}
