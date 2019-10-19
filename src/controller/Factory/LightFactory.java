package controller.Factory;

import model.items.IEquipableItem;
import model.items.Light;

public class LightFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Light(setting + " Light", power, minRange, maxRange);
    }
}
