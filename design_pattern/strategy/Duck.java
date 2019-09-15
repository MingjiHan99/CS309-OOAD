

public abstract class Duck{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

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

    public void setFlyBehavior(FlyBehavior flybBehavior){
        this.flyBehavior = flybBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
    

}