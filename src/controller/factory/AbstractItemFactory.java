package controller.factory;

import model.units.IUnit;

/**
 * This class represents an abstract item factory. It contains the logic for item creation.
 *
 * @author Agustin Matthey
 * @version 1.0
 * @since 1.0
 */

public abstract class AbstractItemFactory implements ItemFactory {

    protected String name;
    protected double power = 15;
    protected int maxRange = 3;
    protected int minRange = 1;
    protected String setting = "Normal";
    protected IUnit owner;

    public void setNormalItem(){
        power = 15;
        minRange = 1;
        maxRange = 3;
        setting = "Normal";
    }

    public void setStrongItem(){
        power = 25;
        minRange = 1;
        maxRange = 3;
        setting = "Strong";
    }

    public void setHighRangeItem(){
        power = 15;
        minRange = 1;
        maxRange = 6;
        setting = "High-range";
    }

    public void setOwner(IUnit owner){
        this.owner = owner;
    }



}
