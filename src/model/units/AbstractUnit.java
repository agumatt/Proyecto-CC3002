package model.units;

import static java.lang.Math.min;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Tactician;
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
  private Tactician tactician;

  public Tactician getTactician() {
    return tactician;
  }

  public void setTactician(Tactician tactician) {
    this.tactician = tactician;
  }



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
  protected AbstractUnit(final double hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = hitPoints;
    this.currentHitPoints=hitPoints;
    this.movement = movement;
    if (location.getUnit() == null && hitPoints>0){
    this.location = location;}
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
   for(IEquipableItem i:items){
      i.setOwner(this);
    }

    }



  public void giveItemTo(IUnit unit, IEquipableItem gift){
      if(gift.getOwner()==this && (this.location.distanceTo(unit.getLocation())==1) && currentHitPoints>0){
        unit.receiveItem(gift);
        if(gift.getOwner()==unit){
        this.items.remove(gift);
        }
      }}



  @Override
  public void receiveItem(IEquipableItem gift) {
    if (this.items.size() < 3) {
      this.items.add(gift);
      gift.setOwner(this);
    }
  }

  @Override
  public void useEquippedItem(IUnit unit){
    if(currentHitPoints>0){
    double dist=location.distanceTo(unit.getLocation());
    if (equippedItem != null) {

    if(equippedItem.getMinRange()<=dist && dist<=equippedItem.getMaxRange()) {
      equippedItem.useItem(unit);
      if (unit.getCurrentHitPoints()>0 && unit.getEquippedItem()!=null) {
        unit.getEquippedItem().counterAttack(this);
      }
    }
    if(this.getCurrentHitPoints()<=0){
        this.setLocation(null);
    }
    if(unit.getCurrentHitPoints()<=0){
        unit.setLocation(null);
    }
    }
    }}




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
