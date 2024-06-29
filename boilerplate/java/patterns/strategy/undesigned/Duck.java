package patterns.strategy.undesigned;

public abstract class Duck {
    public void quack(){
        System.out.println("Quack Quack!!");
    }
    public void swim(){
        System.out.println("Swimming..");
    }

    public abstract void display();

    // Requirements to add fly functionality

    public void fly(){
        System.out.println("Flying...");
    }
}
