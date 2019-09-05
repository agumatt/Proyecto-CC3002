package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

public class LightTest extends AbstractTestItem {

    private Light light;
    private Light wrongLight;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Light Ray";
        expectedPower = 4;
        expectedMinRange = 1;
        expectedMaxRange = 8;
        light = new Light(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    @Override
    public void setWrongRangeItem() {
        wrongLight = new Light("Wrong light", 0, -3, -5);
    }

    @Override
    public void setTestUnit()  {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0));

    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongLight;
    }

    @Override
    public IEquipableItem getTestItem() {
        return light;
    }

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
