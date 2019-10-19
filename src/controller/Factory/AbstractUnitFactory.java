package controller.Factory;


import model.items.IEquipableItem;
import model.map.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnitFactory implements UnitFactory {

    protected double maxHitPoints = 75;
    protected double currentHitPoints = 75;
    protected int movement = 2;
    protected String setting = "Normal";
    protected Location location;
    protected List<IEquipableItem> items = new ArrayList<>();



    public void setWeakUnit(){
        maxHitPoints = 50;
        currentHitPoints = 50;
        movement = 2;
        setting = "Weak";
    }

    public void setNormalUnit(){
        maxHitPoints = 75;
        currentHitPoints = 75;
        movement = 2;
        setting = "Normal";
    }

    public void setDurableUnit(){
        maxHitPoints = 100;
        currentHitPoints = 100;
        movement = 2;
        setting = "Durable";
    }

    public void setItems(ArrayList<IEquipableItem> items){
       this.items = items;
    }

    public void setLocation(Location location){
        this.location=location;
    }

}
