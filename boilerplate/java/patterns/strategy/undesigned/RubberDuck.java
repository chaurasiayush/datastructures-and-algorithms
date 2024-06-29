package patterns.strategy.undesigned;

public class RubberDuck extends Duck {
    
    @Override
    public void display(){
        System.out.println("A Rubber Duck!");
    }

    @Override
    public void quack(){
        System.out.println("Squeak Squeak");
    }
}
