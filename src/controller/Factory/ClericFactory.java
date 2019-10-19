package controller.Factory;

import model.units.Cleric;
import model.units.IUnit;

public class ClericFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Cleric(maxHitPoints, movement,location,items);
    }
}
