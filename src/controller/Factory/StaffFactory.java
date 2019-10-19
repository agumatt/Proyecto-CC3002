package controller.Factory;

import model.items.IEquipableItem;
import model.items.Staff;

public class StaffFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Staff(setting + " Staff", power, minRange, maxRange);
    }
}
