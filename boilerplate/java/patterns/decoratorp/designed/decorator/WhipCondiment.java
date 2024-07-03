package patterns.decoratorp.designed.decorator;

import patterns.decoratorp.designed.beverage.Beverage;

public class WhipCondiment extends CondimentDecorator {
    
    private Beverage beverage;
    
    public WhipCondiment(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.20f;
    }
}
