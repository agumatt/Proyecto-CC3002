package controller.Factory;

import model.items.IEquipableItem;
import model.items.Sword;

public class SwordFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Sword(setting + " Sword", power, minRange, maxRange);
    }
}
