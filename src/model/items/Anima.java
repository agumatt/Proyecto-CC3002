package model.items;

import model.units.*;

/**
 * This class represents an Anima.
 * <p>
 * Anima are strong against Lights but weak against Darkness.
 *
 * @author Agustin Matthey
 * @since 2.0
 */

public class Anima extends AbstractMagicalItem {

    /**
     * Creates a new anima item
     *
     * @param name
     *     the name of the anima
     * @param power
     *     the damage of the anima
     * @param minRange
     *     the minimum range of the anima
     * @param maxRange
     *     the maximum range of the anima
     */

    public Anima(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    public double inflictAttack(IEquipableItem item){
        return ((IMagicalItem) item).receiveAnimaAttack(this);
    }

    public double receiveAnimaAttack(IMagicalItem item){
        return item.getPower();
    }
    public double receiveDarknessAttack(IMagicalItem item){
        return item.getPower()*1.5;
    }
    public double receiveLightAttack(IMagicalItem item){
        double ans=item.getPower()-20;
        if(ans<0){
            ans=0;
        }
        return ans;
    }



}
