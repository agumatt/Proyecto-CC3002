package model.items;

import model.units.*;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Agustin Matthey
 * @since 2.0
 */
public class Spear extends AbstractNonMagicalItem {

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
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }




  public double inflictAttack(IEquipableItem item){
    return ((INonMagicalItem) item).receiveSpearAttack(this);
  }

  public double receiveAxeAttack(INonMagicalItem item){
    return item.getPower()*1.5;
  }
  public double receiveBowAttack(INonMagicalItem item){
    return item.getPower();
  }
  public double receiveSwordAttack(INonMagicalItem item){
    double ans=item.getPower()-20;
    if(ans<0){
      ans=0;
    }
    return ans;
  }
  public double receiveSpearAttack(INonMagicalItem item){
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
    hero.setEquippedItem(this);
    owner=hero;
  }

  @Override
  public void equipToSwordMaster(SwordMaster swordMaster) {

  }


}
