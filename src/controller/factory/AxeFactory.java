package controller.factory;

import model.items.Axe;
import model.items.IEquipableItem;

/**
 * This class is in charge of generating Axes.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */

public class AxeFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem axe = new Axe(setting + " Axe", power, minRange, maxRange);
        axe.setOwner(owner);
        return axe;
    }
}
