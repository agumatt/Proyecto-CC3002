package controller.Factory;

import model.items.Darkness;
import model.items.IEquipableItem;

public class DarknessFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem darkness = new Darkness(setting + " Darkness", power, minRange, maxRange);
        darkness.setOwner(owner);
        return darkness;
     }
}
