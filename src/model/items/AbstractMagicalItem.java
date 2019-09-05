package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public abstract class AbstractMagicalItem extends AbstractItem implements IMagicalItem {

    public AbstractMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }

    @Override
    public double receiveMagicalDamage(IMagicalItem item){
        return ((IEquipableItem) item).inflictAttack(this);
    }

    @Override
    public void useItem(IUnit unit) {
        unit.setCurrentHitPoints(unit.getCurrentHitPoints()-this.inflictMagicalDamage(unit.getEquippedItem()));
    }

    public double inflictMagicalDamage(IEquipableItem item){
        if(item==null){
            return this.getPower();
        }
        return item.receiveMagicalDamage(this);

    }

    @Override
    public double inflictNonMagicalDamage(IEquipableItem item) {
        return 0;
    }


    public double receiveNonMagicalDamage(INonMagicalItem item){
        return item.getPower()*1.5;
    }

    public void equipToSorcerer(Sorcerer sorcerer) {
        sorcerer.setEquippedItem(this);
        this.owner=sorcerer;
    }

}
