package patterns.strategy.designed.duck;

import patterns.strategy.designed.behaviour.fly.FlyWithWings;
import patterns.strategy.designed.behaviour.quack.Quack;

public class RedHeadDuck extends Duck{
    public RedHeadDuck(){
        this.quackBehaviour = new Quack();
        this.flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display(){
        System.out.println("A Red Head Duck");
    }
}
