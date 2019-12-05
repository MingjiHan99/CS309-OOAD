package original_adapter;

import java.util.List;

public class MultiAdapter implements FileOperateInterfaceV2, ManageStaffInterface {

    FileOperateInterfaceV1 fileOperate;
    ManageStaffInterface manager;

    MultiAdapter(FileOperateInterfaceV1 fileOperate, ManageStaffInterface manager){
        this.fileOperate = fileOperate;
        this.manager = manager;
    }
    @Override
    public List<StaffModel> readAllStaff() {
        return this.fileOperate.readStaffFile();
    }

    @Override
    public void listAllStaff(List<StaffModel> list) {
        this.fileOperate.printStaffFile(list);
    }

    @Override
    public void writeByName(List<StaffModel> list) {
        this.fileOperate.writeStaffFile(list);
    }

    @Override
    public void writeByPeopleId(List<StaffModel> list) {
        this.fileOperate.writeStaffFile(list);
    }

    @Override
    public void addNewStaff(List<StaffModel> list) {
        manager.addingStaff(list);
    }

    @Override
    public void removeStaffByMaxPeopleId(List<StaffModel> list) {

    }

    @Override
    public void addingStaff(List<StaffModel> list) {
        manager.addingStaff(list);
    }

    @Override
    public void removeStaff(List<StaffModel> list, String name) {
        manager.removeStaff(list, name);
    }
}
