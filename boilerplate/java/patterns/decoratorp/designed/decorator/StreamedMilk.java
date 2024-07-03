package patterns.decoratorp.designed.decorator;

import patterns.decoratorp.designed.beverage.Beverage;

public class StreamedMilk extends CondimentDecorator {
    
    private Beverage beverage;
    
    public StreamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", Streamed Milk";
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.10f;
    }
}
