package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public class Darkness extends AbstractMagicalItem{


    public Darkness(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipToSorcerer(Sorcerer sorcerer) {

    }


}
