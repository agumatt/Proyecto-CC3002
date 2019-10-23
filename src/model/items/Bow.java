package model.items;

import model.units.*;

/**
 * This class represents a <i>bow</i>.
 * <p>
 *
 * @author Agustin Matthey
 * @since 2.0
 */
public class Bow extends AbstractNonMagicalItem {

  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final double power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }



  public double inflictAttack(IEquipableItem item){
    return ((INonMagicalItem) item).receiveBowAttack(this);
  }

  public double receiveAxeAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveBowAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveSwordAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveSpearAttack(INonMagicalItem item){
    return item.getPower();
  }


  @Override
  public void equipToArcher(Archer archer) {
    archer.setEquippedItem(this);
    owner=archer;
  }

  @Override
  public void equipToCleric(Cleric cleric) {

  }

  @Override
  public void equipToFighter(Fighter fighter) {

  }

  @Override
  public void equipToHero(Hero hero) {

  }

  @Override
  public void equipToSwordMaster(SwordMaster swordMaster) {

  }

}
