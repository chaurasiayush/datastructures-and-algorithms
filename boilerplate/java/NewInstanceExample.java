import java.lang.reflect.Constructor;
import java.util.*;

class Dog {
    public Dog(){};
    public void bark(){
        System.out.println("Bhau bhau!");
    }
}

public class NewInstanceExample {

    public static void main(String[] args) throws Exception{
    
        // depricated method
        Dog dog = Dog.class.newInstance();
        dog.bark();

        Constructor<Dog> dcons = Dog.class.getConstructor();
        Dog newdog = dcons.newInstance();
        newdog.bark();

    }
}