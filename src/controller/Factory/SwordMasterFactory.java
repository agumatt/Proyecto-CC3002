package controller.Factory;

import model.units.IUnit;
import model.units.SwordMaster;

public class SwordMasterFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new SwordMaster(maxHitPoints, movement,location,items);
    }
}
