package controller.factory;

import model.items.IEquipableItem;
import model.items.Staff;

/**
 * This class is in charge of generating Staffs.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class StaffFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem staff = new Staff(setting + " Staff", power, minRange, maxRange);
        staff.setOwner(owner);
        return staff;
    }
}
