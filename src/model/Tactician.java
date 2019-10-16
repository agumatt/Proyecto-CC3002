package model;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

   private String name;
   private IUnit selectedUnit;
   private final ArrayList<Tactician> units = new ArrayList<>();
   private PropertyChangeSupport ownHeroDied;
   private PropertyChangeSupport otherHeroDied;
   private PropertyChangeSupport outOfUnits;

   public Tactician(String name){
     this.name=name;
   }

   public String getName() {
   return name;
   }



    /**
     * Sets the currently equipped item of this unit.
     *
     * @param item
     *     the item to equip
     */
   public void equipItem(IEquipableItem item){
        selectedUnit.equipItem(item);
    }

    /**
     * @return hit points of the unit
     */
   public double getCurrentHitPoints(){
        return selectedUnit.getCurrentHitPoints();
    }


    /**
     * @return maximum hit points of the unit
     */
   public double getMaxHitPoints(){
        return selectedUnit.getMaxHitPoints();
    }

    /**
     * Sets the current hitPoints of this unit.
     * @param hitPoints
     *     the hitPoints to be set
      */
   public void setCurrentHitPoints(double hitPoints){
        selectedUnit.setCurrentHitPoints(hitPoints);
    }

    /**
     * @return the items carried by this unit
     */
   public List<IEquipableItem> getItems(){
        return List.copyOf(selectedUnit.getItems());
    }

    /**
     * @return the currently equipped item
     */
   public IEquipableItem getEquippedItem(){
        return selectedUnit.getEquippedItem();
    }

    /**
     * @param item
     *     the item to be equipped
     */
   public void setEquippedItem(IEquipableItem item){
        selectedUnit.setEquippedItem(item);
    }

    /**
     * @return the current location of the unit
     */
   public Location getLocation(){
        return selectedUnit.getLocation();
    }

    /**
     * Sets a new location for this unit,
     */
   public void setLocation(final Location location){
        selectedUnit.setLocation(location);
    }

    /**
     * Gives an item to another unit
     * @param unit
     * the unit that gives the item
     * @param item
     * the item to be given
     */
   public void giveItemTo(IUnit unit, IEquipableItem item){
        selectedUnit.giveItemTo(unit,item);
    }

    /**
     * receive an item from another unt
     * @param gift
     * the item to be received
     */
   public void receiveItem(IEquipableItem gift){
        selectedUnit.receiveItem(gift);
    }

    /**
     * @return the number of cells this unit can move
     */
   public int getMovement(){
      return selectedUnit.getMovement();
    }

    /**
     * @param unit
     * the unit on which the equipped item will be used.
     */
   public  void useEquippedItem(IUnit unit){
        selectedUnit.useEquippedItem(unit);
    }

    /**
     * Moves this unit to another location.
     * <p>
     * If the other location is out of this unit's movement range, the unit doesn't move.
     */
   public void moveTo(Location targetLocation){
        selectedUnit.moveTo(targetLocation);
    }
}
