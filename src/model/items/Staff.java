package model.items;

import model.units.*;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractNonMagicalItem {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }


  public void useItem(IUnit unit){}

  @Override
  public void equipToArcher(Archer archer) {

  }

  @Override
  public void equipToCleric(Cleric cleric) {
    cleric.setEquippedItem(this);
    owner=cleric;
  }

  @Override
  public void equipToFighter(Fighter fighter) {

  }

  @Override
  public void equipToHero(Hero hero) {

  }

  @Override
  public void equipToSwordMaster(SwordMaster swordMaster) {

  }

  @Override
  public void equipToSorcerer(IUnit unit) {

  }

}
