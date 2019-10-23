package controller.factory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

import java.util.ArrayList;

/**
 * This interface contains the structure given to every item factory.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public interface UnitFactory{

    /**
     * @return the created unit
     */
    IUnit createProduct();

    /**
     * Set the "weak" setting for the creation of the next unit.
     */
    void setWeakUnit();

    /**
     * Set the "normal" setting for the creation of the next unit.
     *
     */
    void setNormalUnit();

    /**
     * Set the "durable" setting for the creation of the next unit.
     *
     */
    void setDurableUnit();

    /**
     * Sets the items that the unit to be created will be initialized with.
     *
     * @param items
     *     the items to be set.
     */
    void setItems(ArrayList<IEquipableItem> items);

    /**
     * Sets the location that the unit to be created will be initialized with.
     *
     * @param location
     *     the location to be set.
     */
    void setLocation(Location location);

}
