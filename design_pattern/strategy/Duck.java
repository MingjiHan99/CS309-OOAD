

public abstract class Duck{
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
    public Duck(){

    }
    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks can swim");
    }

}