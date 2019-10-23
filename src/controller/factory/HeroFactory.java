package controller.factory;

import model.units.Hero;
import model.units.IUnit;



/**
 * This class is in charge of generating Heroes.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class HeroFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Hero(maxHitPoints, movement,location,items);
    }
}
