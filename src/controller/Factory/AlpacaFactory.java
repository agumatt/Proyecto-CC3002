package controller.Factory;

import model.units.Alpaca;
import model.units.IUnit;

public class AlpacaFactory extends AbstractUnitFactory {

    @Override
    public IUnit createProduct() {
        return new Alpaca(maxHitPoints, movement,location,items);
    }
}
