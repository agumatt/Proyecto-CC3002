package model.units;

import model.items.IEquipableItem;
import model.items.IMagicalItem;
import model.map.Location;

/**
 * This class represents a <i>Sorcerer</i> type unit.
 * <p>
 * A <i>Sorcerer</i> is a unit that <b>can only use magical weapons</b>.
 *
 * @author Agustin Matthey
 * @since 2.0
 */

public class Sorcerer extends AbstractUnit{

    public Sorcerer(final int hitPoints, final int movement, final Location location,
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
            ((IMagicalItem) item).equipToSorcerer(this);
        }
    }

    @Override
    public boolean gameChanger() {
        return false;
    }
}


