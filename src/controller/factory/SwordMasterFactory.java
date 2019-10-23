package controller.factory;

import model.units.IUnit;
import model.units.SwordMaster;

/**
 * This class is in charge of generating SwordMasters.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */

public class SwordMasterFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new SwordMaster(maxHitPoints, movement,location,items);
    }
}
