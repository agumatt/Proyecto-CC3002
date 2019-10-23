package controller.factory;

import model.units.IUnit;
import model.units.Sorcerer;

/**
 * This class is in charge of generating Sorcerers.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class SorcererFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Sorcerer(maxHitPoints, movement,location,items);
    }
}
