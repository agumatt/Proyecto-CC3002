package model.items;

import model.units.*;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {




  /**
   * generates the inflicted magical damage on an item.
   * @param item
   * the item that will receive the attack
   * @return
   * the amount of damage to be dealt
   */
  double inflictMagicalDamage(IEquipableItem item);
  /**
   * generates the inflicted non-magical damage on an item.
   * @param item
   * the item that will receive the attack
   * @return
   * the amount of damage to be dealt
   */
  double inflictNonMagicalDamage(IEquipableItem item);
  /**
   * generates the received magical damage from an item.
   * @param item
   * the item that attacks
   * @return
   * the amount of damage to be dealt
   */
  double receiveMagicalDamage(IEquipableItem item);
  /**
   * generates the received non-magical damage from an item.
   * @param item
   * the item that attacks
   * @return
   * the amount of damage to be dealt
   */
  double receiveNonMagicalDamage(IEquipableItem item);

  /**
   * generates the inflicted damage on an item.
   * @param item
   * the item that will receive the attack
   * @return
   * the amount of damage to be dealt
   */
  double inflictAttack(IEquipableItem item);


  /**
   * @return the unit that has currently equipped this item
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


  /**
   * sets a new owner for the item
   * @param unit
   *     the new owner of the item
   */
  void setOwner(IUnit unit);

  @Override
  boolean equals(Object o);

  /**
   * use an Item
   * @param unit
   *     the unit that uses the item
   */
  void useItem(IUnit unit);

  /**
   * @param unit
   *     this unit attacks back
   */
  void counterAttack(IUnit unit);

}