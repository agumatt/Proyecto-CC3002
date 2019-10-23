package controller.factory;

import model.units.Alpaca;
import model.units.IUnit;

/**
 * This class is in charge of generating Alpacas.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public class AlpacaFactory extends AbstractUnitFactory {

    @Override
    public IUnit createProduct() {
        return new Alpaca(maxHitPoints, movement,location,items);
    }
}
