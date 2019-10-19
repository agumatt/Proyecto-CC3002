package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

/**
 * This class represents a Darkness.
 * <p>
 * Darkness are strong against Anima but weak against Light.
 *
 * @author Agustin Matthey
 * @since 2.0
 */


public class Darkness extends AbstractMagicalItem{

    /**
     * Creates a new darkness item
     *
     * @param name
     *     the name of the darkness
     * @param power
     *     the damage of the darkness
     * @param minRange
     *     the minimum range of the darkness
     * @param maxRange
     *     the maximum range of the darkness
     */
    public Darkness(final String name, final double power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    public double inflictAttack(IEquipableItem item){
        return ((IMagicalItem) item).receiveDarknessAttack(this);
    }

    public double receiveAnimaAttack(IMagicalItem item){
        double ans=item.getPower()-20;
        if(ans<0){
            ans=0;
        }
        return ans;
    }
    public double receiveDarknessAttack(IMagicalItem item){
        return item.getPower();
    }
    public double receiveLightAttack(IMagicalItem item){
        return item.getPower()*1.5;
    }




}
