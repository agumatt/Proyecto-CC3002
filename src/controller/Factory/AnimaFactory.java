package controller.Factory;

import model.items.Anima;
import model.items.IEquipableItem;

public class AnimaFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem anima = new Anima(setting + " Anima", power, minRange, maxRange);
        anima.setOwner(owner);
        return anima;
    }
}
