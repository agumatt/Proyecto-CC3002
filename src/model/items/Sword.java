package model.items;

import model.units.*;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractNonMagicalItem {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public Sword(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }


  @Override
  public double receiveNonMagicalDamage(INonMagicalItem item) {
    return inflictSwordAttack(item);
  }

  public double inflictAxeAttack(INonMagicalItem item){
    return 0;
  }
  public double inflictBowAttack(INonMagicalItem item){
    return 0;
  }
  public double inflictStaffAttack(INonMagicalItem item){
    return 0;
  }
  public double inflictSwordAttack(INonMagicalItem item){
    return item.receiveSwordAttack(this);
  }
  public double inflictSpearAttack(INonMagicalItem item){
    return 0;
  }

  public double receiveAxeAttack(INonMagicalItem item){
    return item.getPower()-20;
  }
  public double receiveBowAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveSwordAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveSpearAttack(INonMagicalItem item){
    return item.getPower()*1.5;
  }
  public double receiveStaffAttack(INonMagicalItem item){
    return item.getPower();
  }

  @Override
  public void equipToArcher(Archer archer) {

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
    swordMaster.setEquippedItem(this);
    owner=swordMaster;
  }

}
