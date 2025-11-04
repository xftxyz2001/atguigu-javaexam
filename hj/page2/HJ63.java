import java.util.Scanner;

public class HJ63 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String dna = in.next();
        int n = in.nextInt();
        in.close();
        System.out.println(getSubStr(dna, n));
    }

    private static String getSubStr(String dna, int n) {

        // ArrayList<String> subStringList = new ArrayList<>();
        int maxCgCnt = -1;
        String maxCgCntSubString = null;
        for (int i = 0; i <= dna.length() - n; i++) {
            // subStringList.add(dna.substring(i, i + n));
            String substring = dna.substring(i, i + n);
            int cgCnt = cgCnt(substring);
            if (cgCnt > maxCgCnt) {
                maxCgCnt = cgCnt;
                maxCgCntSubString = substring;
            }
        }
        return maxCgCntSubString;
    }

    private static int cgCnt(String str) {
        int cgCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char chi = str.charAt(i);
            if (chi == 'C' || chi == 'G') {
                cgCnt++;
            }
        }
        return cgCnt;
    }
}
