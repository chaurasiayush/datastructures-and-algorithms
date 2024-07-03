package patterns.decoratorp.designed.decorator;

import patterns.decoratorp.designed.beverage.Beverage;

public class MochaCondiment extends CondimentDecorator {
    
    private Beverage beverage;
    
    public MochaCondiment(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.20f;
    }
}
