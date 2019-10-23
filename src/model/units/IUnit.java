package model.units;

import java.util.List;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  void equipItem(IEquipableItem item);


    /**
     * @return player that owns the unit
     */
  Tactician getTactician();


    /**
     * Sets the owner of this unit.
     * @param tactician
     *     the tactician to be set
     */
  void setTactician(Tactician tactician);

  /**
   * @return hit points of the unit
   */
  double getCurrentHitPoints();


  /**
   * @return maximum hit points of the unit
   */
  double getMaxHitPoints();

  /**
   * Sets the current hitPoints of this unit.
   * @param hitPoints
   *     the hitPoints to be set
   */
  void setCurrentHitPoints(double hitPoints);

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /**
   * @param item
   *     the item to be equipped
   */
  void setEquippedItem(IEquipableItem item);

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * Determines if the loss of the unit makes you lose the game instantly
   */
  boolean gameChanger();

  /**
   * Gives an item to another unit
   * @param unit
   * the unit that gives the item
   * @param item
   * the item to be given
   */
  void giveItemTo(IUnit unit, IEquipableItem item);

  /**
   * receive an item from another unt
   * @param gift
   * the item to be received
   */
  void receiveItem(IEquipableItem gift);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * @param unit
   * the unit on which the equipped item will be used.
   */
 void useEquippedItem(IUnit unit);

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);
}
