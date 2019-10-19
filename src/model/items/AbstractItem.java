package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Agustin Matthey
 * @since 2.0
 */
public abstract class AbstractItem implements IEquipableItem {

  protected final String name;
  protected final double power;
  protected int maxRange;
  protected int minRange;
  protected IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final double power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange+1);
  }


   @Override
   public boolean equals(Object o){
    if(o instanceof IEquipableItem){
      return ((IEquipableItem) o).getMinRange()==minRange && ((IEquipableItem) o).getMaxRange()==maxRange &&
              ((IEquipableItem) o).getName()==name && ((IEquipableItem) o).getPower()==power && ((IEquipableItem) o).getOwner()==owner;
    }
    return false;
    }



  public void counterAttack(IUnit unit){
    useItem(unit);
  }


  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

  @Override
  public void setOwner(IUnit unit){
    this.owner=unit;
  }


}
