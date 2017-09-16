package design.pattern.builder;

public abstract class ColdDrink implements IItem {

    @Override
    public IPacking packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
