package controller.factory;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * This interface contains the structure given to every item factory.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */
public interface ItemFactory{

    /**
     * @return the created item.
     */
    IEquipableItem createProduct();

    /**
     * Set the "normal" setting for the creation of the next item.
     */
    void setNormalItem();

    /**
     * Set the "strong" setting for the creation of the next unit.
     */
    void setStrongItem();

    /**
     * Set the "high-range" setting for the creation of the next unit.
     */
    void setHighRangeItem();

    /**
     * Sets the owner of the item to be created.
     *
     * @param owner
     *     the owner to be set.
     */
    void setOwner(IUnit owner);

}
