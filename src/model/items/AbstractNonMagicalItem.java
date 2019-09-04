package model.items;

import model.units.*;

public abstract class AbstractNonMagicalItem extends AbstractItem implements INonMagicalItem{

    public AbstractNonMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }

    @Override
    public void useItem(IUnit unit) {
        this.inflictNonMagicalDamage(unit.getEquippedItem());
    }
    public double inflictNonMagicalDamage(IEquipableItem item);
    public double receiveNonMagicalDamage(IEquipableItem item);

}

    public double receiveMagicalDamage(IEquipableItem item){
        return item.getPower()*1.5;
    }

    abstract public double inflictAxeAttack(INonMagicalItem item);
    abstract public double inflictBowAttack(INonMagicalItem item);
    abstract public double inflictStaffAttack(INonMagicalItem item);
    abstract public double inflictSwordAttack(INonMagicalItem item);
    abstract public double inflictSpearAttack(INonMagicalItem item);
    abstract public double receiveAxeAttack(INonMagicalItem item);
    abstract public double receiveBowAttack(INonMagicalItem item);
    abstract public double receiveStaffAttack(INonMagicalItem item);
    abstract public double receiveSwordAttack(INonMagicalItem item);
    abstract public double receiveSpearAttack(INonMagicalItem item);




    abstract public void equipToArcher(Archer archer);
    abstract public void equipToCleric(Cleric cleric);
    abstract public void equipToFighter(Fighter fighter);
    abstract public void equipToHero(Hero hero);
    abstract public void equipToSwordMaster(SwordMaster swordMaster);

}
