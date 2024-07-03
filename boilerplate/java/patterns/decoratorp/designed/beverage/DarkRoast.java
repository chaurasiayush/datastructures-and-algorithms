package patterns.decoratorp.designed.beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.description = "Dark Roast";
    }
    
    @Override
    public float cost() {
        return .99f;
    }
    
}
