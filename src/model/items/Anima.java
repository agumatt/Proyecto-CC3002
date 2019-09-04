package model.items;

import model.units.*;

public class Anima extends AbstractMagicalItem {

    public Anima(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    public double receiveMagicalDamage(IEquipableItem item){

    }
    public double receiveNonMagicalDamage(IEquipableItem item){

    }

    @Override
    public void equipToSorcerer(Sorcerer sorcerer) {

    }
}
