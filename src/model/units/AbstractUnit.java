package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  private final double maxHitPoints;
  protected double currentHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = hitPoints;
    this.currentHitPoints=hitPoints;
    this.movement = movement;
    if (location.getUnit() == null){
    this.location = location;}
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  public void giveItem(IUnit unit, IEquipableItem gift){
      if(this.items.contains(gift) && (this.location.distanceTo(unit.getLocation())==1) && currentHitPoints>0){
        for (IEquipableItem i : unit.getItems()){
             if(i==null){
               unit.getItems().add(gift);
               this.items.remove(gift);
               break;
             }
        }

      }

  }

  @Override
  public void receiveItem(IUnit unit, IEquipableItem gift){
    unit.giveItem(this,gift);
  }

  @Override
  public void useEquippedItem(IUnit unit){
    double dist=location.distanceTo(unit.getLocation());
    if (equippedItem != null) {

    if(equippedItem.getMinRange()<=dist && dist<=equippedItem.getMaxRange() && currentHitPoints>0) {
      equippedItem.useItem(unit);
      if (unit.getCurrentHitPoints()>0 && unit.getEquippedItem()!=null) {
        unit.getEquippedItem().counterAttack(this);
      }
    }
    }
    }




  public double getMaxHitPoints(){
    return maxHitPoints;
  }
  @Override
  public double getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public void setCurrentHitPoints(double hitPoints){
    currentHitPoints=hitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem item) {
    this.equippedItem = item;
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null && currentHitPoints>0) {
      setLocation(targetLocation);
    }
  }
}
