package controller.Factory;

import model.units.IUnit;
import model.units.Sorcerer;

public class SorcererFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Sorcerer(maxHitPoints, movement,location,items);
    }
}
