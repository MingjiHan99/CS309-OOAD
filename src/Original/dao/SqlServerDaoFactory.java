package original.dao;

import original.bean.Staff;

public class SqlServerDaoFactory implements DaoFactory {

    @Override
    public StaffDao createStaffDao(){
        return new SqlServerStaffDao();
    }

    @Override
    public ComputerDao createComputerDao(){
        return new SqlServerComputerDao();
    }
}
