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
    noCounterattackHero = new Hero(1, 2, field.getCell(1, 1));
    secondHero = new Hero(1, 2, field.getCell(2, 2));
    this.spear2 = new Spear("Spear", 10, 1, 5);
    this.spear3 = new Spear("Spear", 10, 1, 5);
    spear2.setOwner(noCounterattackHero);
    spear3.setOwner(secondHero);
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

  @Test
  @Override
  public void testUseEquippedItem() {
    //unidad desarmada vs unidad desarmada
    hero.useEquippedItem(cleric);
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(1000,hero.getCurrentHitPoints());
    secondHero.equipItem(spear3);
    //unidad principal desarmada
    secondHero.useEquippedItem(hero);
    assertEquals(990,hero.getCurrentHitPoints());
    assertEquals(1,secondHero.getCurrentHitPoints());

    equipWeapons();
    sorcerer.useEquippedItem(hero);
    assertEquals(975,hero.getCurrentHitPoints());
    assertEquals(35,sorcerer.getCurrentHitPoints());

    sorcerer2.useEquippedItem(hero);
    assertEquals(960,hero.getCurrentHitPoints());
    assertEquals(35,sorcerer2.getCurrentHitPoints());

    sorcerer3.useEquippedItem(hero);
    assertEquals(945,hero.getCurrentHitPoints());
    assertEquals(35,sorcerer3.getCurrentHitPoints());

    archer.useEquippedItem(hero);
    assertEquals(935,hero.getCurrentHitPoints());
    assertEquals(40,archer.getCurrentHitPoints());

    fighter.useEquippedItem(hero);
    assertEquals(920,hero.getCurrentHitPoints());
    assertEquals(50,fighter.getCurrentHitPoints());

    swordMaster.useEquippedItem(hero);
    assertEquals(920,hero.getCurrentHitPoints());
    assertEquals(35,swordMaster.getCurrentHitPoints());

    //ataque de unidad del mismo tipo
    secondHero.useEquippedItem(hero);
    assertEquals(910,hero.getCurrentHitPoints());
    assertEquals(-9,secondHero.getCurrentHitPoints());

    alpaca.useEquippedItem(hero);
    assertEquals(910,hero.getCurrentHitPoints());
    assertEquals(50,alpaca.getCurrentHitPoints());

    cleric.useEquippedItem(hero);
    assertEquals(920,hero.getCurrentHitPoints());

    //unidad con poca vida no logra contraatacar
    archer.useEquippedItem(noCounterattackHero);
    assertEquals(-9,noCounterattackHero.getCurrentHitPoints());
    assertEquals(920,hero.getCurrentHitPoints());

    //ataque de unidad fuera de combate
    noCounterattackHero.useEquippedItem(hero);
    assertEquals(920,hero.getCurrentHitPoints());
    assertEquals(-9,noCounterattackHero.getCurrentHitPoints());

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