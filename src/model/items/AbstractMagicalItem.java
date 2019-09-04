package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public abstract class AbstractMagicalItem extends AbstractItem {

    public AbstractMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }

    @Override
    public void useItem(IUnit unit) {
          this.inflictMagicalDamage(unit.getEquippedItem());
    }
    public double inflictMagicalDamage(IEquipableItem item){
        return item.receiveMagicalDamage(this);

    }

    public double receiveNonMagicalDamage(IEquipableItem item){
        return item.getPower()*1.5;
    }

    abstract public void equipToSorcerer(Sorcerer sorcerer);

}
