package controller.Factory;

import model.items.IEquipableItem;
import model.items.Light;

public class LightFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem light = new Light(setting + " Light", power, minRange, maxRange);
        light.setOwner(owner);
        return light;
    }
}
