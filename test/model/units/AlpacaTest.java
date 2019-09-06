package model.units;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {
  private Alpaca weakAlpaca;
  private Alpaca deadAlpaca;

  public void setTestUnit(){
    alpaca = new Alpaca(1000, 2, field.getCell(0, 0));
    weakAlpaca = new Alpaca(1, 2, field.getCell(1, 1));
    deadAlpaca = new Alpaca(0, 2, field.getCell(2, 2));
  }



  public void setOtherTestUnits(){
    sorcerer= new Sorcerer(50,2,field.getCell(0,1));
    sorcerer2= new Sorcerer(50,2,field.getCell(0,2));
    sorcerer3= new Sorcerer(50,2,field.getCell(0,3));
    archer =new Archer(50,2,field.getCell(1,3));
    cleric =new Cleric(50,2,field.getCell(1,2));
    fighter =new Fighter(50,2,field.getCell(2,3));
    hero =new Hero(50,2,field.getCell(2,4));
    swordMaster =new SwordMaster(50,2,field.getCell(2,8));
  }

  @Override
  public void testUseEquippedItem() {

  }


  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }
}