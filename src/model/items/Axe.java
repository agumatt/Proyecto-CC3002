package model.items;

import model.units.*;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Agustin Matthey
 * @since 2.0
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
  public Axe(final String name, final double power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }



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
    double ans=item.getPower()-20;
    if(ans<0){
      ans=0;
    }
    return ans;
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
