package controller.Factory;

import model.items.Bow;
import model.items.IEquipableItem;

public class BowFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Bow(setting + " Bow", power, minRange, maxRange);
    }
}
