package singleton;

public class Singleton {
    private volatile static Singleton uniqueInstance; // volatile : no thread local cache

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){ // synchronized field
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }



}
