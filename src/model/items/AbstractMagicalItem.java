package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public abstract class AbstractMagicalItem extends AbstractItem {

    public AbstractMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }


    abstract public void equipToSorcerer(Sorcerer sorcerer);

}
