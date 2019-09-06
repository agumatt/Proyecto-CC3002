package model.units;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  public void setTestUnit(){
    alpaca = new Alpaca(50, 2, field.getCell(0, 0));

  }

  public void setOtherTestUnits(){
    sorcerer= new Sorcerer(50,2,field.getCell(0,1));
    archer =new Archer(50,2,field.getCell(1,1));
    cleric =new Cleric(50,2,field.getCell(1,2));
    fighter =new Fighter(50,2,field.getCell(2,3));
    hero =new Hero(50,2,field.getCell(2,4));
    swordMaster =new SwordMaster(50,2,field.getCell(2,8));
  }


  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }
}