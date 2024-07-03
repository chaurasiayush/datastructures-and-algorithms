package patterns.decoratorp.designed.beverage;

public abstract class Beverage {
    String description = "Unknown description";

    public String getDescription(){
        return this.description;
    }

    public abstract float cost();
}