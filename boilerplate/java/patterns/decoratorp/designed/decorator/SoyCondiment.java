package patterns.decoratorp.designed.decorator;

import patterns.decoratorp.designed.beverage.Beverage;

public class SoyCondiment extends CondimentDecorator {
    
    private Beverage beverage;
    
    public SoyCondiment(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.15f;
    }
}
