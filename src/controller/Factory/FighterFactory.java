package controller.Factory;

import model.units.Fighter;
import model.units.IUnit;

public class FighterFactory extends AbstractUnitFactory {
    @Override
    public IUnit createProduct() {
        return new Fighter(maxHitPoints, movement,location,items);
    }
}
