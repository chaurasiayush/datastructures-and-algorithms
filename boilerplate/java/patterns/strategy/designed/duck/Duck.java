package patterns.strategy.designed.duck;

import patterns.strategy.designed.behaviour.fly.FlyBehaviour;
import patterns.strategy.designed.behaviour.quack.QuackBehaviour;

public abstract class Duck {
    protected QuackBehaviour quackBehaviour;
    protected FlyBehaviour flyBehaviour;

    public void performQuck(){
        this.quackBehaviour.quack();
    }

    public void performFly(){
        this.flyBehaviour.fly();
    }

    public void swim(){
        System.out.println("Swimming...");
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }

    public abstract void display();
}
