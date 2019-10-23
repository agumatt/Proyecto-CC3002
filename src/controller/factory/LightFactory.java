package controller.factory;

import model.items.IEquipableItem;
import model.items.Light;

/**
 * This class is in charge of generating Light.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class LightFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem light = new Light(setting + " Light", power, minRange, maxRange);
        light.setOwner(owner);
        return light;
    }
}
