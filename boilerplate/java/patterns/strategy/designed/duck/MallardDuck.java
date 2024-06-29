package patterns.strategy.designed.duck;

import patterns.strategy.designed.behaviour.fly.FlyWithWings;
import patterns.strategy.designed.behaviour.quack.Quack;

public class MallardDuck extends Duck {
    
    public MallardDuck() {
        this.quackBehaviour = new Quack();
        this.flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display(){
        System.out.println("A Mallard Duck");
    }
}
