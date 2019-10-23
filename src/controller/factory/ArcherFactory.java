package controller.factory;

import model.units.Archer;
import model.units.IUnit;

/**
 * This class is in charge of generating Archers.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */

public class ArcherFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Archer(maxHitPoints, movement,location,items);
    }
}
