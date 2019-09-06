package model.items;

import model.units.*;

public interface IMagicalItem {

    boolean equals(Object o);
    double receiveAnimaAttack(IMagicalItem item);
    double receiveDarknessAttack(IMagicalItem item);
    double receiveLightAttack(IMagicalItem item);
    double inflictMagicalDamage(IEquipableItem item);
    double inflictNonMagicalDamage(IEquipableItem item);
    double receiveMagicalDamage(IEquipableItem item);
    double receiveNonMagicalDamage(IEquipableItem item);
    double inflictAttack(IEquipableItem item);
    void equipToSorcerer(Sorcerer sorcerer);


    IUnit getOwner();

    /**
     * @return the name of the item
     */
    String getName();

    /**
     * @return the power of the item
     */
    double getPower();

    /**
     * @return the minimum range of the item
     */
    int getMinRange();

    /**
     * @return the maximum range of the item
     */
    int getMaxRange();


}
