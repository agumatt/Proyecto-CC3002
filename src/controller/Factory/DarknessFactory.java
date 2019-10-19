package controller.Factory;

import model.items.Darkness;
import model.items.IEquipableItem;

public class DarknessFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Darkness(setting + " Darkness", power, minRange, maxRange);
    }
}
