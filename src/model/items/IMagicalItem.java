package model.items;

import model.units.*;

/**
 * This interface represents the <i>magical weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of magical weapons are defined here.
 * Magical weapons are strong against non-magical weapons.
 *
 * @author Agustin Matthey
 * @since 2.0
 */

public interface IMagicalItem {

    @Override
    boolean equals(Object o);

    /**
     * generates the damage received by an anima.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveAnimaAttack(IMagicalItem item);

    /**
     * generates the damage received by a darkness.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveDarknessAttack(IMagicalItem item);

    /**
     * generates the damage received by a light.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveLightAttack(IMagicalItem item);

    /**
     * generates the inflicted magical damage on an item.
     * @param item
     * the item that will receive the attack
     * @return
     * the amount of damage to be dealt
     */
    double inflictMagicalDamage(IEquipableItem item);

    /**
     * generates the inflicted damage on an item.
     * @param item
     * the item that will receive the attack
     * @return
     * the amount of damage to be dealt
     */
    double inflictAttack(IEquipableItem item);

    /**
     * equip item to a sorcerer.
     * @param sorcerer
     * the unit that will equip the item.
     */
    void equipToSorcerer(Sorcerer sorcerer);


    /**
     * @return the owner of the item
     */
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
