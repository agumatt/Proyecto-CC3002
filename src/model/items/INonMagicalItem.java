package model.items;

import model.units.*;

public interface INonMagicalItem {

    @Override
    boolean equals(Object o);

    /**
     * generates the damage received by an axe.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveAxeAttack(INonMagicalItem item);

    /**
     * generates the damage received by a bow.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveBowAttack(INonMagicalItem item);

    /**
     * generates the damage received by a sword.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveSwordAttack(INonMagicalItem item);

    /**
     * generates the damage received by a spear.
     * @param item
     * the item that inflicts the attack
     * @return
     * the amount of damage to be dealt
     */
    double receiveSpearAttack(INonMagicalItem item);

    /**
     * generates the inflicted non-magical damage on an item.
     * @param item
     * the item that will receive the attack
     * @return
     * the amount of damage to be dealt
     */
    double inflictNonMagicalDamage(IEquipableItem item);
    /**
     * generates the inflicted damage on an item.
     * @param item
     * the item that will receive the attack
     * @return
     * the amount of damage to be dealt
     */
    double inflictAttack(IEquipableItem item);

    /**
     * equip item to a archer.
     * @param archer
     * the unit that will equip the item.
     */
    void equipToArcher(Archer archer);
    /**
     * equip item to a cleric.
     * @param cleric
     * the unit that will equip the item.
     */
    void equipToCleric(Cleric cleric);
    /**
     * equip item to a fighter.
     * @param fighter
     * the unit that will equip the item.
     */
    void equipToFighter(Fighter fighter);
    /**
     * equip item to a hero.
     * @param hero
     * the unit that will equip the item.
     */
    void equipToHero(Hero hero);
    /**
     * equip item to a swordMaster.
     * @param swordMaster
     * the unit that will equip the item.
     */
    void equipToSwordMaster(SwordMaster swordMaster);

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
