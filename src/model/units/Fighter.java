package model.units;

import model.items.Axe;
import model.items.IEquipableItem;
import model.items.INonMagicalItem;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Agustin Matthey
 * @since 2.0
 */
public class Fighter extends AbstractUnit {

  public Fighter(final double hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  @Override
  public void equipItem(final IEquipableItem item) {
    if (item.getOwner() == this) {
      ((INonMagicalItem) item).equipToFighter(this);
    }
  }

  @Override
  public boolean gameChanger() {
    return false;
  }
}
