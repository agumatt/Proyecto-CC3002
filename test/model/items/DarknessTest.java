package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.SorcererTest;

public class DarknessTest extends AbstractTestItem {
    private Darkness darkness;
    private Darkness wrongDarkness;
    private SorcererTest sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Dark void";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        darkness = new Darkness(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    @Override
    public void setWrongRangeItem() {
        wrongDarkness = new Darkness("Wrong light", 0, -3, -5);
    }

    @Override
    public void setTestUnit()  {
        sorcerer = new SorcererTest(10, 5, new Location(0, 0));

    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongDarkness;
    }

    @Override
    public IEquipableItem getTestItem() {
        return darkness;
    }

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

}
