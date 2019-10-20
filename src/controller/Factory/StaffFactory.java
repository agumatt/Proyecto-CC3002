package controller.Factory;

import model.items.IEquipableItem;
import model.items.Staff;

public class StaffFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem staff = new Staff(setting + " Staff", power, minRange, maxRange);
        staff.setOwner(owner);
        return staff;
    }
}
