package controller.Factory;

import model.units.Hero;
import model.units.IUnit;

public class HeroFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Hero(maxHitPoints, movement,location,items);
    }
}
