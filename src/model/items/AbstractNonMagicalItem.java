package model.items;

import model.units.*;

public abstract class AbstractNonMagicalItem extends AbstractItem {

    public AbstractNonMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }

    @Override
    public void useItem(IUnit unit) {

    }

    abstract public void inflictNonMagicalDamage();

    abstract public void equipToArcher(Archer archer);
    abstract public void equipToCleric(Cleric cleric);
    abstract public void equipToFighter(Fighter fighter);
    abstract public void equipToHero(Hero hero);
    abstract public void equipToSwordMaster(SwordMaster swordMaster);

}
