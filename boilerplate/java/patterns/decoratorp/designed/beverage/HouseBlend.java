package patterns.decoratorp.designed.beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "HouseBlend";
    }
    
    @Override
    public float cost() {
        return .99f;
    }
    
}
