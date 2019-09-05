package model.items;

import model.units.*;

public abstract class AbstractNonMagicalItem extends AbstractItem implements INonMagicalItem{

    public AbstractNonMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }

    public void useItem(IUnit unit){
        unit.setCurrentHitPoints(unit.getCurrentHitPoints()-this.inflictNonMagicalDamage(unit.getEquippedItem()));
    }


    @Override
    public double inflictNonMagicalDamage(IEquipableItem item) {
        return item.receiveNonMagicalDamage((INonMagicalItem) item);
    }

    @Override
    public double receiveNonMagicalDamage(INonMagicalItem item){
        return ((IEquipableItem) item).inflictAttack(this);
    }

    public double inflictMagicalDamage(IEquipableItem item){
        return 0;
    }

    @Override
    public double receiveMagicalDamage(IMagicalItem item){
        return item.getPower()*1.5;
    }




    abstract public void equipToArcher(Archer archer);
    abstract public void equipToCleric(Cleric cleric);
    abstract public void equipToFighter(Fighter fighter);
    abstract public void equipToHero(Hero hero);
    abstract public void equipToSwordMaster(SwordMaster swordMaster);

}
