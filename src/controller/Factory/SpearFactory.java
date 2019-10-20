package controller.Factory;

import model.items.IEquipableItem;
import model.items.Spear;

public class SpearFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem spear = new Spear(setting + " Spear", power, minRange, maxRange);
        spear.setOwner(owner);
        return spear;
    }
}
