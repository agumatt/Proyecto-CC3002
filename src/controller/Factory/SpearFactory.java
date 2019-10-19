package controller.Factory;

import model.items.IEquipableItem;
import model.items.Spear;

public class SpearFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Spear(setting + " Spear", power, minRange, maxRange);
    }
}
