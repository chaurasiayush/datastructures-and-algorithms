package patterns.strategy.designed.duck;

import patterns.strategy.designed.behaviour.fly.FlyNoWay;
import patterns.strategy.designed.behaviour.quack.Squeak;

public class RubberDuck extends Duck{
    
    public RubberDuck() {
        this.quackBehaviour = new Squeak();
        this.flyBehaviour = new FlyNoWay();
    }

    @Override
    public void display(){
        System.out.println("A Rubber Duck");
    }
}
