package controller.Factory;

import model.items.Axe;
import model.items.IEquipableItem;

public class AxeFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem axe = new Axe(setting + " Axe", power, minRange, maxRange);
        axe.setOwner(owner);
        return axe;
    }
}
