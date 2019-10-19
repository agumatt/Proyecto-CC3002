package controller.Factory;

import model.items.Anima;
import model.items.IEquipableItem;

public class AnimaFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        return new Anima(setting + " Anima", power, minRange, maxRange);
    }
}
