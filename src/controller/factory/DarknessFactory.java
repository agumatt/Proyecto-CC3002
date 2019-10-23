package controller.factory;

import model.items.Darkness;
import model.items.IEquipableItem;

/**
 * This class is in charge of generating Darkness.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class DarknessFactory extends AbstractItemFactory {
    @Override
    public IEquipableItem createProduct() {
        IEquipableItem darkness = new Darkness(setting + " Darkness", power, minRange, maxRange);
        darkness.setOwner(owner);
        return darkness;
     }
}
