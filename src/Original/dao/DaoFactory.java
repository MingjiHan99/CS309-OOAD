package original.dao;

public interface DaoFactory {
    public ComputerDao createComputerDao();
    public StaffDao createStaffDao();
}
