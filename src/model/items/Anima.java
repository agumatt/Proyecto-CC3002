package model.items;

import model.units.*;

public class Anima extends AbstractMagicalItem {

    public Anima(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    public double inflictAttack(IEquipableItem item){
        return ((IMagicalItem) item).receiveAnimaAttack(this);
    }

    public double receiveAnimaAttack(IMagicalItem item){
        return item.getPower();
    }
    public double receiveDarknessAttack(IMagicalItem item){
        return item.getPower()*1.5;
    }
    public double receiveLightAttack(IMagicalItem item){
        return item.getPower()-20;
    }


    @Override
    public void equipToSorcerer(Sorcerer sorcerer) {

    }
}
