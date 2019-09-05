package model.items;

import model.units.*;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractNonMagicalItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }



  public void useItem(IUnit unit){}
  public void counterAttack(IUnit unit){}





  public double inflictAttack(IEquipableItem item){
    return ((INonMagicalItem) item).receiveAxeAttack(this);
  }

  public double receiveAxeAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveBowAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveSwordAttack(INonMagicalItem item){
    return item.getPower()*1.5;
  }
  public double receiveSpearAttack(INonMagicalItem item){
    return item.getPower()-20;
  }


  @Override
  public void equipToArcher(Archer archer) {

  }

  @Override
  public void equipToCleric(Cleric cleric) {

  }

  @Override
  public void equipToFighter(Fighter fighter) {
    fighter.setEquippedItem(this);
    owner=fighter;
  }

  @Override
  public void equipToHero(Hero hero) {

  }

  @Override
  public void equipToSwordMaster(SwordMaster swordMaster) {

  }

}
