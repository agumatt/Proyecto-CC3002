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
        if(item==null){
            return this.getPower();
        }
        return item.receiveNonMagicalDamage(item);
    }

    @Override
    public double receiveNonMagicalDamage(IEquipableItem item){
        return item.inflictAttack(this);
    }

    public double inflictMagicalDamage(IEquipableItem item){
        return 0;
    }

    @Override
    public double receiveMagicalDamage(IEquipableItem item){
        return item.getPower()*1.5;
    }






}
