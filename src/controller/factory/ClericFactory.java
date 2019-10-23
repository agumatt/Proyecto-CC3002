package controller.factory;

import model.units.Cleric;
import model.units.IUnit;


/**
 * This class is in charge of generating Clerics.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class ClericFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Cleric(maxHitPoints, movement,location,items);
    }
}
