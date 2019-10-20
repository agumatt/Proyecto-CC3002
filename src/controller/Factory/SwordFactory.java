package controller.Factory;

import model.items.IEquipableItem;
import model.items.Sword;

public class SwordFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem sword = new Sword(setting + " Sword", power, minRange, maxRange);
        sword.setOwner(owner);
        return sword;
    }
}
