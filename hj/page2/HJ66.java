import java.util.HashMap;
import java.util.Scanner;

public class HJ66 {
    public static void main(String[] args) {
        HashMap<String, String> cmdMap = new HashMap<>();
        cmdMap.put("reset", "reset what");
        cmdMap.put("reset board", "board fault");
        cmdMap.put("board add", "where to add");
        cmdMap.put("board delete", "no board at all");
        cmdMap.put("reboot backplane", "impossible");
        cmdMap.put("backplane abort", "install first");

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String cmd = in.nextLine();
            String[] splitCmd = cmd.split(" ");

            String bestMatch = null;
            // int[] splitCmdMatchCharNumBest = new int[splitCmd.length];

            l: for (String key : cmdMap.keySet()) {
                String[] splitKey = key.split(" ");
                if (splitCmd.length != splitKey.length) { // 命令关键字数不匹配
                    continue;
                }
                int[] splitCmdMatchCharNum = new int[splitCmd.length];
                for (int i = 0; i < splitCmd.length; i++) {
                    if (splitCmd[i].length() > splitKey[i].length()) {
                        continue l;
                    }
                    if (!splitKey[i].startsWith(splitCmd[i])) {
                        continue l;
                    }
                    splitCmdMatchCharNum[i] = splitCmd[i].length();
                }
                if (bestMatch!=null) {
                    bestMatch = null;
                    break;
                } else {
                    bestMatch = key;
                }
                // int diff = 0;
                // for (int i = 0; i < splitCmdMatchCharNumBest.length; i++) {
                //     if (splitCmdMatchCharNum[i] < splitCmdMatchCharNumBest[i]) {
                //         continue l;
                //     }
                //     diff += splitCmdMatchCharNum[i] - splitCmdMatchCharNumBest[i];
                // }
                // if (diff == 0) {
                //     bestMatch = null;
                //     break;
                // } else {
                //     bestMatch = key;
                // }
            }
            if (bestMatch != null) {
                System.out.println(cmdMap.get(bestMatch));
            } else {
                System.out.println("unknown command");
            }
        }
        in.close();
    }
}
