package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Spear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {


  private Hero noCounterattackHero;
  private Hero secondHero;
  private Spear spear2;
  private Spear spear3;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    hero = new Hero(1000, 2, field.getCell(0, 0));
    noCounterattackHero = new Hero(50, 2, field.getCell(1, 1));
    secondHero = new Hero(50, 2, field.getCell(2, 2));
  }


  public void setOtherTestUnits(){
    alpaca= new Alpaca(50,2,field.getCell(0,1));
    archer =new Archer(50,2,field.getCell(1,3));
    cleric =new Cleric(50,2,field.getCell(1,2));
    fighter =new Fighter(50,2,field.getCell(2,3));
    sorcerer =new Sorcerer(50,2,field.getCell(2,4));
    sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
    sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
    swordMaster =new SwordMaster(50,2,field.getCell(2,8));
  }

  @Override
  public void testUseEquippedItem() {

  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  @Override
  @Test
  public void equipSpearTest() {
    spear.setOwner(hero);
    assertNull(hero.getEquippedItem());
    hero.equipItem(spear);
    assertEquals(spear, hero.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    anima.setOwner(hero);
    assertNull(hero.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      hero.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(hero);
    assertNull(hero.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      hero.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    darkness.setOwner(hero);
    assertNull(hero.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      hero.equipItem(darkness);
    });
  }
}