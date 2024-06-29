package patterns.strategy.undesigned;

public class Driver {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck readHeadDuck = new ReadHeadDuck();
        Duck rubberDuck = new RubberDuck();

        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.swim();
        mallardDuck.fly();

        readHeadDuck.display();
        readHeadDuck.quack();
        readHeadDuck.swim();
        readHeadDuck.fly();

        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.swim();
        rubberDuck.fly(); // Should not be able to

    }
}
