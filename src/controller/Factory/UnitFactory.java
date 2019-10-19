package controller.Factory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

import java.util.ArrayList;

public interface UnitFactory{

    public IUnit createProduct();

    public void setWeakUnit();

    public void setNormalUnit();

    public void setDurableUnit();

    public void setItems(ArrayList<IEquipableItem> items);

    public void setLocation(Location location);

}
