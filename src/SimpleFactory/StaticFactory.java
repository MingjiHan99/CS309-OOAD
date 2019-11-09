package SimpleFactory;


// Actually it is not a good design.....
public class StaticFactory {
    static ITStaff createITManager(){
        return new ITManager();
    }

    static ITStaff createITDeveloper(){
        return new Developer();
    }

    static ITStaff createTester(){
        return new Tester();
    }
}
