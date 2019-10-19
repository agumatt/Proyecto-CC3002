package controller.Factory;

import model.items.Axe;
import model.items.IEquipableItem;

public class AxeFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Axe(setting + " Axd", power, minRange, maxRange);
    }
}
