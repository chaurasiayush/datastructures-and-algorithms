package patterns.strategy.designed;

import patterns.strategy.designed.behaviour.fly.FlyWithRocket;
import patterns.strategy.designed.duck.*;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        
        Duck mallardDuck = new MallardDuck();
        Duck redHeadDuck = new RedHeadDuck();
        Duck rubberDuck = new RubberDuck();
        Duck modelDuck = new ModelDuck();

        mallardDuck.display();
        mallardDuck.performQuck();
        mallardDuck.performFly();

        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.performQuck();

        rubberDuck.display();
        rubberDuck.performQuck();
        rubberDuck.performFly();

        modelDuck.display();
        modelDuck.performQuck();
        modelDuck.performFly();

        // changing the behaviour at runtime
        modelDuck.setFlyBehaviour(new FlyWithRocket());
        modelDuck.performFly();

    }
}
