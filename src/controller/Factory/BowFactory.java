package controller.Factory;

import model.items.Bow;
import model.items.IEquipableItem;

public class BowFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem bow = new Bow(setting + " Bow", power, minRange, maxRange);
        bow.setOwner(owner);
        return bow;
    }
}
