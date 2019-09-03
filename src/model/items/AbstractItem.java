package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
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
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  abstract public void equipToArcher(Archer archer);
  abstract public void equipToCleric(Cleric cleric);
  abstract public void equipToFighter(Fighter fighter);
  abstract public void equipToHero(Hero hero);
  abstract public void equipToSwordMaster(SwordMaster swordMaster);
  abstract public void equipToSorcerer(IUnit unit);

  public void useItem(IUnit unit){
      unit.setCurrentHitPoints(unit.getCurrentHitPoints()-this.power);
      unit.getEquippedItem().counterAttack(this.owner);
  }
  public void counterAttack(IUnit unit){
      unit.setCurrentHitPoints(unit.getCurrentHitPoints()-this.power);
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
  public int getPower() {
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
}
