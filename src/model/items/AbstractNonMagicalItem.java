package model.items;

public abstract class AbstractNonMagicalItem extends AbstractItem {

    public AbstractNonMagicalItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name,power,minRange,maxRange);
    }
}
