package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected Light light;
  protected Darkness darkness;
  protected Anima anima;

  protected Alpaca alpaca;
  protected Sorcerer sorcerer;
  protected Sorcerer sorcerer2;
  protected Sorcerer sorcerer3;
  protected Archer archer;
  protected Cleric cleric;
  protected Fighter fighter;
  protected Hero hero;
  protected SwordMaster swordMaster;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }


  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
    setOtherTestUnits();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
            new Location(0, 3),new Location(0, 4),new Location(1, 0), new Location(1, 1), new Location(1, 2),new Location(1, 3), new Location(1, 4),new Location(2, 0),
        new Location(2, 1), new Location(2, 2),new Location(2, 3),new Location(2, 4),new Location(2, 5),new Location(2, 6),
            new Location(2, 7),new Location(2, 8));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  abstract public void setTestUnit();


  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 10);
    this.sword = new Sword("Sword", 10, 1, 10);
    this.spear = new Spear("Spear", 10, 1, 10);
    this.staff = new Staff("Staff", 10, 1, 10);
    this.bow = new Bow("Bow", 10, 2, 10);
    this.anima = new Anima("Devouring souls", 10, 1, 10);
    this.darkness = new Darkness("Dark void", 10, 1, 10);
    this.light = new Light("Light Ray", 10, 1, 10);
  }

  @Override
  public void setWeaponsReducedReach() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.anima = new Anima("Devouring souls", 7, 4, 8);
    this.darkness = new Darkness("Dark void", 10, 2, 3);
    this.light = new Light("Light Ray", 4, 1, 8);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(1000, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }



  @Test
  public void equipDarknessTest(){checkEquippedItem(getDarkness());}

  public Darkness getDarkness(){return darkness;}


  @Test
  public void equipLightTest(){checkEquippedItem(getLight());}

  public Light getLight(){return light;}


  @Test
  public void equipAnimaTest(){checkEquippedItem(getAnima());}

  public Anima getAnima(){return anima;}

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }


  @Override
  public void equipWeapons(){
    bow.setOwner(archer);
    staff.setOwner(cleric);
    axe.setOwner(fighter);
    spear.setOwner(hero);
    sword.setOwner(swordMaster);
    darkness.setOwner(sorcerer);
    light.setOwner(sorcerer2);
    anima.setOwner(sorcerer3);
    archer.equipItem(bow);
    cleric.equipItem(staff);
    fighter.equipItem(axe);
    hero.equipItem(spear);
    swordMaster.equipItem(sword);
    sorcerer.equipItem(darkness);
    sorcerer2.equipItem(light);
    sorcerer3.equipItem(anima);
  }
  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  abstract public void setOtherTestUnits();

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }


  @Override
  abstract public void testUseEquippedItem();




}
