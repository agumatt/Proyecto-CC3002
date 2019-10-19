package model.units;

import model.items.IEquipableItem;
import model.items.INonMagicalItem;
import model.map.Location;

/**
 * This class represents a <i>SwordMaster</i> type unit.
 * <p>
 * A <i>SwordMaster</i> is a unit that <b>can only use sword type weapons</b>.
 *
 * @author Agustin Matthey
 * @since 2.0
 */
public class SwordMaster extends AbstractUnit {

  public SwordMaster(final double hitPoints, final int movement, final Location location,
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
      ((INonMagicalItem) item).equipToSwordMaster(this);
    }
  }

  @Override
  public boolean gameChanger() {
    return false;
  }
}
