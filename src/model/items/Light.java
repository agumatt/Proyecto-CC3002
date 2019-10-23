package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

/**
 * This class represents a Light.
 * <p>
 * Lights are strong against Darkness but weak against Anima.
 *
 * @author Agustin Matthey
 * @since 2.0
 */


public class Light extends AbstractMagicalItem {

    /**
     * Creates a new light item
     *
     * @param name
     *     the name of the light
     * @param power
     *     the damage of the light
     * @param minRange
     *     the minimum range of the light
     * @param maxRange
     *     the maximum range of the light
     */

    public Light(final String name, final double power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }


    public double inflictAttack(IEquipableItem item){
        return ((IMagicalItem) item).receiveLightAttack(this);
    }

    public double receiveAnimaAttack(IMagicalItem item){
        return item.getPower()*1.5;
    }
    public double receiveDarknessAttack(IMagicalItem item){
        double ans=item.getPower()-20;
        if(ans<0){
            ans=0;
        }
        return ans;
    }
    public double receiveLightAttack(IMagicalItem item){
        return item.getPower();
    }


}
