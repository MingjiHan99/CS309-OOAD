package SimpleFactory;

import SimpleFactory.ITManager;
import SimpleFactory.Tester;

public class SimpleFactory {

    ITStaff createITStaff(int parameter) {
        switch (parameter) {
            case 1:
                return new ITManager();

            case 2:
                return new Developer();

            case 3:
                return new Tester();

        }
        return null;
    }
}
