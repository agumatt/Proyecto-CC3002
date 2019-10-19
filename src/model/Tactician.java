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

   public String getName() {
   return name;
   }

   public IUnit getSelectedUnit() {
        return selectedUnit;
    }

   public void setSelectedUnit(IUnit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public IEquipableItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(IEquipableItem selectedItem) {
        this.selectedItem = selectedItem;
    }


    public void removeUnit(IUnit unit){
       units.remove(unit);
   }


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
                      changes.firePropertyChange(new PropertyChangeEvent(this,"attacked player defeated",unit.getTactician(),null));
               }else{      //notAHero defeated
                      changes.firePropertyChange(new PropertyChangeEvent(this,"attacked unit defeated",unit,null));
               }
        }
        //attacking player
        if(selectedUnit.getCurrentHitPoints()<=0){
              if(units.size()==1 || selectedUnit.gameChanger()){      //last unit or hero defeated
                  changes.firePropertyChange(new PropertyChangeEvent(this,"current player defeated",this,null));
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
