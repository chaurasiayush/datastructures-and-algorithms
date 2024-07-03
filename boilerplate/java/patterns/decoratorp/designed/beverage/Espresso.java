package patterns.decoratorp.designed.beverage;

public class Espresso extends Beverage {

    public Espresso() {
        this.description = "Espresso";
    }
    
    @Override
    public float cost() {
        return 2.90f;
    }
    
}
