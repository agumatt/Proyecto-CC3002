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
   * Equips this item to a unit.
   *
   * @param unit the unit that will be quipped with the item
   */


  /**
   * @return the unit that has currently equipped this item
   */

  double inflictMagicalDamage(IEquipableItem item);
  double inflictNonMagicalDamage(IEquipableItem item);
  double receiveMagicalDamage(IMagicalItem item);
  double receiveNonMagicalDamage(INonMagicalItem item);
  double inflictAttack(IEquipableItem item);


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


  void useItem(IUnit unit);

  void counterAttack(IUnit unit);

}