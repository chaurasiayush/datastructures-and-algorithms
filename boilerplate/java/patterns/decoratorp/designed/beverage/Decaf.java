package patterns.decoratorp.designed.beverage;

public class Decaf extends Beverage {

    public Decaf() {
        this.description = "Decaf";
    }
    @Override
    public float cost() {
        return 1.20f;
    }
    
}
