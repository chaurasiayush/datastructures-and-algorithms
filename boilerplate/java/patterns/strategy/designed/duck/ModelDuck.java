package patterns.strategy.designed.duck;

import patterns.strategy.designed.behaviour.fly.FlyNoWay;
import patterns.strategy.designed.behaviour.quack.MuteQuack;

public class ModelDuck extends Duck{

    public ModelDuck(){
        this.flyBehaviour = new FlyNoWay();
        this.quackBehaviour = new MuteQuack();
    }

    @Override
    public void display(){
        System.out.println("A Model Duck");
    }
    
}
