package model;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

   private String name;
   private IEquipableItem selectedItem;
   private IUnit selectedUnit;
   private final ArrayList<IUnit> units = new ArrayList<>();
   private PropertyChangeSupport changes;




    /**
     * This class represents a player, and gathers all the elements that form one.
     *
     * @author Agustin Matthey
     * @version 1.0
     * @since 1.0
     */


    /**
     * Creates a new player.
     *
     * @param name
     *     the name of the player
     */
    public Tactician(String name){
     this.name=name;
     changes = new PropertyChangeSupport(this);
   }

   @Override
   public boolean equals(Object o){
     if(!(o instanceof Tactician)){
         return false;
     }
     return this.getName().equals(((Tactician) o).getName());
   }

    /**
     * @return name of the player
     */
   public String getName() {
   return name;
   }


    /**
     * Sets the units owned by this player.
     * @param units
     *     the units to be set
     */
   public void setUnits(ArrayList<IUnit> units){
       this.units.addAll(units);
       for(IUnit u : units){
           u.setTactician(this);
       }
   }

    /**
     * @return the unit that is currently selected
     */
   public IUnit getSelectedUnit() {
        return selectedUnit;
    }
    /**
     * Selects a unit to be used.
     * @param selectedUnit
     *     the units to be selected
     */
   public void setSelectedUnit(IUnit selectedUnit) {
       if(selectedUnit==null || this.equals(selectedUnit.getTactician())){
        this.selectedUnit = selectedUnit;}
    }

    /**
     * @return the item that has been selected
     */
    public IEquipableItem getSelectedItem() {
        return selectedItem;
    }

    /**
     * Select an item
     * @param selectedItem
     *     the item to be selected
     */
    public void setSelectedItem(IEquipableItem selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * Removes a unit from the players list.
     * @param unit
     *     the units to be removed
     */
    public void removeUnit(IUnit unit){
       units.remove(unit);
   }


    /**
     * @return the units owned by the player
     */
   public List<IUnit> getUnits() {
        return List.copyOf(units);
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
     * @return the number of cells this unit can move
     */
   public int getMovement(){
      return selectedUnit.getMovement();
    }

    /**
     * add an observer
     * @param respHandler
     * the response handler class
     */
   public void addObserver(PropertyChangeListener respHandler){
          changes.addPropertyChangeListener(respHandler);
   }
    /**
     * @param unit
     * the unit on which the equipped item will be used.
     */
   public  void useEquippedItem(IUnit unit){
        selectedUnit.useEquippedItem(unit);
        //notify events
        //attacked player
        if(unit.getCurrentHitPoints()<=0){
               if(unit.getTactician().getUnits().size()==1 || unit.gameChanger()){      //last unit or hero defeated
                      changes.firePropertyChange(new PropertyChangeEvent(this,"player defeated",unit.getTactician(),null)); //attacked player defeated
               }else{      //notAHero defeated
                      changes.firePropertyChange(new PropertyChangeEvent(this,"attacked unit defeated",unit,null));
               }
        }
        //attacking player
        if(selectedUnit.getCurrentHitPoints()<=0){
              if(units.size()==1 || selectedUnit.gameChanger()){      //last unit or hero defeated
                  changes.firePropertyChange(new PropertyChangeEvent(this,"player defeated",this,null)); //current player defeated
              }else{      //notAHero defeated
                  changes.firePropertyChange(new PropertyChangeEvent(this,"selected unit defeated",selectedUnit,null));
                }
            }
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
