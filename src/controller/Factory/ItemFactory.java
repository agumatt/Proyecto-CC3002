package controller.Factory;

import model.items.IEquipableItem;
import model.units.IUnit;

public interface ItemFactory{

    public IEquipableItem createProduct();

    public void setNormalItem();

    public void setStrongItem();

    public void setHighRangeItem();

    public void setOwner(IUnit owner);

}
