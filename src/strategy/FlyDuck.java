package strategy;
public class FlyDuck extends Duck{

    FlyDuck(){
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I am a fly duck.");
    }

    public static void main(String []args){
        Duck d = new FlyDuck();
        d.performFly();
        d.display();
        d.performQuack();
    }
}