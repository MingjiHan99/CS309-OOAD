package original.dao;


import java.lang.reflect.InvocationTargetException;

public class DaoFactoryImpl implements DaoFactory {

    private static DaoFactoryImpl daoFactory = null;
    private String name;
    private static String packageName = "original.dao.";
    private static String staffPostfix = "StaffDao";
    private static String computerPostfix = "ComputerDao";

    private DaoFactoryImpl(String name){
        this.name = name;


    }

    public static DaoFactoryImpl getInstance(String name){

        synchronized (DaoFactoryImpl.class){
            if(daoFactory == null){
                daoFactory = new DaoFactoryImpl(name);

            }
            return daoFactory;
        }

    }

    @Override
    public StaffDao createStaffDao() {
        Object object = null;

        return (StaffDao)createObjectByReflection(this.packageName + this.name + this.staffPostfix);
    }
    @Override
    public ComputerDao createComputerDao(){
        return (ComputerDao)createObjectByReflection(this.packageName + this.name + this.computerPostfix);
    }

    private static Object createObjectByReflection(String className){
        Object object = null;
        try {
            Class clz = Class.forName(className);
            object = clz.getDeclaredConstructor().newInstance();

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String []args){
        DaoFactory factory = new DaoFactoryImpl("Mysql");
        ComputerDao computerDao = factory.createComputerDao();
        StaffDao staffDao = factory.createStaffDao();



    }
}
