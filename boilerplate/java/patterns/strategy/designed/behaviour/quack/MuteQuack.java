package patterns.strategy.designed.behaviour.quack;

public class MuteQuack implements QuackBehaviour {
    
    @Override
    public void quack(){
        System.out.println("<<  SILENCE >>");
    }
}
