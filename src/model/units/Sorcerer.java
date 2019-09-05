package model.units;

import model.items.IEquipableItem;
import model.items.IMagicalItem;
import model.map.Location;

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
        ((IMagicalItem)item).equipToSorcerer(this);
    }
}


