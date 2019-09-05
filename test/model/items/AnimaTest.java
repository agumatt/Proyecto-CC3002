package model.items;


import model.map.Location;
import model.units.IUnit;
import model.units.SorcererTest;

public class AnimaTest extends AbstractTestItem {

    private Anima anima;
    private Anima wrongAnima;
    private SorcererTest sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Devouring souls";
        expectedPower = 7;
        expectedMinRange = 4;
        expectedMaxRange = 8;
        anima = new Anima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    @Override
    public void setWrongRangeItem() {
        wrongAnima = new Anima("Wrong anima", 0, -3, -5);
    }

    @Override
    public void setTestUnit()  {
        sorcerer = new SorcererTest(10, 5, new Location(0, 0));

    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongAnima;
    }

    @Override
    public IEquipableItem getTestItem() {
        return anima;
    }

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
