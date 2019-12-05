package original_adapter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperate implements FileOperateInterfaceV1 {

    @Override
    public List<StaffModel> readStaffFile() {
        List<StaffModel> list = new ArrayList<StaffModel>();
        StringBuilder webPage = new StringBuilder();

        try {
            URL url = new URL("http://cse.sustech.edu.cn/en/people/index/sort_id/9");
            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            BufferedReader bufr = new BufferedReader(isr);
            String str;

            while ((str = bufr.readLine()) != null) {
                webPage.append(str.trim());
            }

            Pattern p = Pattern.compile("<a class=\"name\"href=\"([^\"]*)\">([^&]*)&nbsp;&nbsp;&nbsp;&nbsp;([^<]*)");
            Matcher m = p.matcher(webPage);
            Pattern peopleIdPattern = Pattern.compile("people_id/(\\d{1,3})");
            while (m.find()) {
                Matcher peopleIdMatcher = peopleIdPattern.matcher(m.group(1));
                if (peopleIdMatcher.find()) {
                    list.add(new StaffModel(Integer.parseInt(peopleIdMatcher.group(1)), m.group(2), m.group(3).trim(),
                            "http://cse.sustech.edu.cn" + m.group(1)));
                }
            }

            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("finish reading");
        return list;
    }

    @Override
    public void printStaffFile(List<StaffModel> list) {
        if (list.size() == 0) {
            System.out.println("no staff information");
        } else {
            list.forEach(System.out::println);
        }

    }

    @Override
    public void writeStaffFile(List<StaffModel> list) {
        try {
            if (list.size() == 0) {
                System.out.println("No information to be written");
                return;
            }
            FileWriter f = new FileWriter("staff.txt");
            BufferedWriter bufw = new BufferedWriter(f);
            String str = "";
            for (StaffModel s : list) {
                str = s.getPeopleId() + "; " + s.getName() + "; " + s.getTitle() + "; " + s.getLink();
                bufw.write(str);
                bufw.newLine();
            }
            bufw.flush();
            bufw.close();
            System.out.println("finish writing");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
