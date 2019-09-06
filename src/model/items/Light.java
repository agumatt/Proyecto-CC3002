package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public class Light extends AbstractMagicalItem {

    public Light(final String name, final int power, final int minRange, final int maxRange) {
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
