package controller.Factory;

import model.units.Archer;
import model.units.IUnit;

public class ArcherFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Archer(maxHitPoints, movement,location,items);
    }
}
