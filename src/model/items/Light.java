package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public class Light extends AbstractMagicalItem {

    public Light(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }


    public double inflictAttack(IEquipableItem item){
        return ((IMagicalItem) item).receiveLightAttack(this);
    }

    public double receiveAnimaAttack(IMagicalItem item){
        return item.getPower()*1.5;
    }
    public double receiveDarknessAttack(IMagicalItem item){
        return item.getPower()-20;
    }
    public double receiveLightAttack(IMagicalItem item){
        return item.getPower();
    }


    @Override
    public void equipToSorcerer(Sorcerer sorcerer) {

    }
}
