package original_adapter;

import java.util.List;

public class Adapter implements FileOperateInterfaceV2 {

    private FileOperateInterfaceV1 adaptee;
    Adapter(FileOperateInterfaceV1 adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public List<StaffModel> readAllStaff() {
        return this.adaptee.readStaffFile();
    }

    @Override
    public void listAllStaff(List<StaffModel> list) {
        this.adaptee.printStaffFile(list);
    }

    @Override
    public void writeByName(List<StaffModel> list) {
        this.listAllStaff(list);
    }

    @Override
    public void writeByPeopleId(List<StaffModel> list) {
        this.listAllStaff(list);
    }
}
