package patterns.decoratorp;

import patterns.decoratorp.designed.beverage.Beverage;
import patterns.decoratorp.designed.beverage.DarkRoast;
import patterns.decoratorp.designed.decorator.MochaCondiment;
import patterns.decoratorp.designed.decorator.WhipCondiment;

public class StarBuzzCoffeeShop {
    
    public static void main(String[] args) {
        
        //dark roast coffee double mocha whip
        Beverage b1 = new DarkRoast();
        b1 = new MochaCondiment(b1);
        b1 = new MochaCondiment(b1);
        b1 = new WhipCondiment(b1);

        System.out.println(b1.getDescription() + " " + b1.cost());
    }
}
