package model.items;

import model.units.*;

public interface INonMagicalItem {


    double receiveAxeAttack(INonMagicalItem item);
    double receiveBowAttack(INonMagicalItem item);
    double receiveSwordAttack(INonMagicalItem item);
    double receiveSpearAttack(INonMagicalItem item);

    void equipToArcher(Archer archer);
    void equipToCleric(Cleric cleric);
    void equipToFighter(Fighter fighter);
    void equipToHero(Hero hero);
    void equipToSwordMaster(SwordMaster swordMaster);

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