package patterns.decoratorp.designed.decorator;

import patterns.decoratorp.designed.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();
    public abstract float cost();
    
}
