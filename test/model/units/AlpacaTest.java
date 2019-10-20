package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {
  private Alpaca weakAlpaca;
  private Alpaca deadAlpaca;

  public void setTestUnit() {
    alpaca = new Alpaca(1000, 2, field.getCell(0, 0));
    weakAlpaca = new Alpaca(1, 2, field.getCell(1, 1));
    deadAlpaca = new Alpaca(0, 2, field.getCell(2, 2));
  }

  @Override
  @Test
  public void gameChangerTest() {
    assertFalse(weakAlpaca.gameChanger());
  }


  public void setOtherTestUnits() {
    sorcerer = new Sorcerer(50, 2, field.getCell(0, 1));
    sorcerer2 = new Sorcerer(50, 2, field.getCell(0, 2));
    sorcerer3 = new Sorcerer(50, 2, field.getCell(0, 3));
    archer = new Archer(50, 2, field.getCell(1, 3));
    cleric = new Cleric(50, 2, field.getCell(1, 2));
    fighter = new Fighter(50, 2, field.getCell(2, 3));
    hero = new Hero(50, 2, field.getCell(2, 4));
    swordMaster = new SwordMaster(50, 2, field.getCell(2, 8));
  }


  @Test
  public void testGiveItem(){
    alpaca=new Alpaca(100,3,field.getCell(0,0),light,bow,anima,axe,sword);
    fighter=new Fighter(100,3,field.getCell(0,1),darkness,bow,staff);
    assertTrue(fighter.getItems().contains(darkness));
    assertEquals(fighter,darkness.getOwner());
    assertTrue(!(alpaca.getItems().contains(darkness)));

    fighter.giveItemTo(alpaca,darkness);

    assertTrue(alpaca.getItems().contains(darkness));
    assertEquals(alpaca,darkness.getOwner());
    assertTrue(!(fighter.getItems().contains(darkness)));
  }


  @Override
  public void testUseEquippedItem() {

    equipWeapons();
    sorcerer.useEquippedItem(alpaca);
    assertEquals(990,alpaca.getCurrentHitPoints());
    assertEquals(50,sorcerer.getCurrentHitPoints());

    sorcerer2.useEquippedItem(alpaca);
    assertEquals(980,alpaca.getCurrentHitPoints());
    assertEquals(50,sorcerer2.getCurrentHitPoints());

    sorcerer3.useEquippedItem(alpaca);
    assertEquals(970,alpaca.getCurrentHitPoints());
    assertEquals(50,sorcerer3.getCurrentHitPoints());

    archer.useEquippedItem(alpaca);
    assertEquals(960,alpaca.getCurrentHitPoints());
    assertEquals(50,archer.getCurrentHitPoints());

    fighter.useEquippedItem(alpaca);
    assertEquals(950,alpaca.getCurrentHitPoints());
    assertEquals(50,fighter.getCurrentHitPoints());

    swordMaster.useEquippedItem(alpaca);
    assertEquals(940,alpaca.getCurrentHitPoints());
    assertEquals(50,swordMaster.getCurrentHitPoints());


    cleric.useEquippedItem(alpaca);
    assertEquals(950,alpaca.getCurrentHitPoints());



  }


  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }


  @Test
  @Override
  public void equipAnimaTest() {
    anima.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(anima);
    assertNull(alpaca.getEquippedItem());
    }


  @Test
  @Override
  public void equipLightTest() {
    light.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(light);
    assertNull(alpaca.getEquippedItem());
  }

  @Test
  @Override
  public void equipDarknessTest() {
    darkness.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(darkness);
    assertNull(alpaca.getEquippedItem());
  }

  @Test
  @Override
  public void equipAxeTest() {
    axe.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(axe);
    assertNull(alpaca.getEquippedItem());
  }


  @Test
  @Override
  public void equipSpearTest() {
    axe.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(axe);
    assertNull(alpaca.getEquippedItem());
  }


  @Test
  @Override
  public void equipSwordTest() {
    sword.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(sword);
    assertNull(alpaca.getEquippedItem());
  }

  @Test
  @Override
  public void equipStaffTest() {
    staff.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(staff);
    assertNull(alpaca.getEquippedItem());
  }

  @Test
  @Override
  public void equipBowTest() {
    axe.setOwner(alpaca);
    assertNull(alpaca.getEquippedItem());
    alpaca.equipItem(axe);
    assertNull(alpaca.getEquippedItem());
  }


}