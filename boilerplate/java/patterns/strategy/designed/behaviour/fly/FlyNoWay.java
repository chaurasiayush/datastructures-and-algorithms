package patterns.strategy.designed.behaviour.fly;

public class FlyNoWay implements FlyBehaviour{
    @Override
    public void fly(){
        // do nothing
        System.out.println("<<  can't fly >>");
    }
}
