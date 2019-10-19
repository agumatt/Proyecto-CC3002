package controller.Factory;


import model.items.IEquipableItem;
import model.map.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnitFactory implements UnitFactory {

    protected double maxHitPoints = 75;
    protected int movement = 2;
    protected Location location;
    protected IEquipableItem[] items = new IEquipableItem[0];



    public void setWeakUnit(){
        maxHitPoints = 50;
        movement = 2;
    }

    public void setNormalUnit(){
        maxHitPoints = 75;
        movement = 2;
    }

    public void setDurableUnit(){
        maxHitPoints = 100;
        movement = 2;
    }

    public void setItems(ArrayList<IEquipableItem> items){
       this.items = new IEquipableItem[items.size()];
       for(int i=0;i<items.size();i++){
           this.items[i] = items.get(i);
       }
    }

    public void setLocation(Location location){
        this.location=location;
    }

}
