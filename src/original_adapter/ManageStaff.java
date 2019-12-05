package original_adapter;

import java.util.List;
import java.util.Scanner;

public class ManageStaff implements ManageStaffInterface {
    Scanner input = new Scanner(System.in);

    private String inputNoEmptyLine(String tip) {
        System.out.println("Input " + tip + ":");
        String s;
        do {
            s = input.nextLine();
        } while (s.trim().length() == 0);

        return s;
    }

    @Override
    public void addingStaff(List<StaffModel> list) {
        System.out.println("Input peopleId:");
        int peopleId = input.nextInt();
        StaffModel s = new StaffModel(peopleId, inputNoEmptyLine("name"), inputNoEmptyLine("title"),
                inputNoEmptyLine("link"));
        list.add(s);
    }

    @Override
    public void removeStaff(List<StaffModel> list, String name) {
        list.removeIf(staffModel -> staffModel.getName().contains(name));
        System.out.println("success to remove " + name);
    }
}
