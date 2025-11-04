import java.util.ArrayList;
import java.util.Scanner;

class HJ19ErrorRecord {
    String fileName;
    String lineNumer;

    int count;
}

public class HJ19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<HJ19ErrorRecord> recordList = new ArrayList<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] split = line.split(" ");
            int lastIndexOf = split[0].lastIndexOf('\\') + 1;
            if (split[0].length() - lastIndexOf > 16) {
                lastIndexOf = split[0].length() - 16;
            }
            String fileName = split[0].substring(lastIndexOf, split[0].length());
            String lineNumer = split[1];

            boolean flag = false;
            for (HJ19ErrorRecord record : recordList) {
                if (record.fileName.equals(fileName) && record.lineNumer.equals(lineNumer)) {
                    record.count++;
                    flag = true;
                }
            }
            if (!flag) {
                HJ19ErrorRecord errorRecord = new HJ19ErrorRecord();
                errorRecord.fileName = fileName;
                errorRecord.lineNumer = lineNumer;
                errorRecord.count = 1;
                recordList.add(errorRecord);
            }
        }
        in.close();

        // for (HJ19ErrorRecord record : recordList) {
        // System.out.println(record.fileName + " " + record.lineNumer + " " +
        // record.count);
        // }
        int start = recordList.size() - 8;
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < recordList.size(); i++) {
            System.out.println(
                    recordList.get(i).fileName + " " + recordList.get(i).lineNumer + " " + recordList.get(i).count);
        }
    }
}
