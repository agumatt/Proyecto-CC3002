package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {


  private Hero weakHero;
  private Hero deadHero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */

  public void setTestUnit(){
    hero = new Hero(50, 2, field.getCell(0, 0));
    weakHero = new Hero(50, 2, field.getCell(1, 1));
    deadHero = new Hero(50, 2, field.getCell(2, 2));
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
    assertNull(hero.getEquippedItem());
    hero.equipItem(spear);
    assertEquals(spear, hero.getEquippedItem());
  }

  @Override
  public void equipAnimaTest() {
    assertNull(hero.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      hero.equipItem(anima);
    });
  }

  @Test
  @Override
  public void equipLightTest() {
    assertNull(hero.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      hero.equipItem(light);
    });
  }

  @Test
  @Override
  public void equipDarknessTest() {
    assertNull(hero.getEquippedItem());
    Assertions.assertThrows(ClassCastException.class, () -> {
      hero.equipItem(darkness);
    });
  }
}