package controller.factory;

import model.units.Fighter;
import model.units.IUnit;

/**
 * This class is in charge of generating Fighters.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */

public class FighterFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Fighter(maxHitPoints, movement,location,items);
    }
}
