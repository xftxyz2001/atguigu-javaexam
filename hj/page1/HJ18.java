import java.util.Scanner;

/**
 * ∙A 类： * "1.0.0.0" * ∼ * "127.255.255.255"
 * ∙B 类： * "128.0.0.0" * ∼ * "191.255.255.255"
 * ∙C 类： * "192.0.0.0" * ∼ * "223.255.255.255"
 * ∙D 类： * "224.0.0.0" * ∼ * "239.255.255.255"
 * ∙E 类： * "240.0.0.0" * ∼ * "255.255.255.255"
 * 
 * "10.0.0.0" * ∼ * "10.255.255.255"
 * "172.16.0.0" * ∼ * "172.31.255.255"
 * "192.168.0.0" * ∼ * "192.168.255.255"
 */
public class HJ18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int err = 0;
        int pri = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split = line.split("~");
            String IP0 = split[0];
            String IP1 = split[1];

            try {
                int[] ip0Arr = toArray(IP0);
                if (ip0Arr[0] == 0 || ip0Arr[0] == 127) {
                    continue;
                }

                int[] ip1Arr = toArray(IP1);
                if (!checkIP1(ip1Arr)) {
                    err++;
                    continue;
                }
                if (ip0Arr[0] < 128) {
                    A++;
                    if (ip0Arr[0] == 10 || (ip0Arr[0] == 172 && (ip0Arr[1] >= 16 && ip0Arr[1] <= 31))) {
                        pri++;
                    }
                } else if (ip0Arr[0] < 192) {
                    B++;
                } else if (ip0Arr[0] < 224) {
                    C++;
                    if (ip0Arr[0] == 192 && ip0Arr[1] == 168) {
                        pri++;
                    }
                } else if (ip0Arr[0] < 240) {
                    D++;
                } else {
                    E++;
                }
            } catch (Exception e) {
                err++;
            }

        }
        in.close();

        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + err + " " + pri);
    }

    private static boolean checkIP1(int[] ip1Arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ip1Arr.length; i++) {
            String bs = Integer.toBinaryString(ip1Arr[i]);
            for (int j = bs.length(); j < 8; j++) {
                if (bs.length() < 8) {
                    sb.append('0');
                }
            }
            sb.append(bs);
        }
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                if (zeroCount != 0) { // 中间有0
                    return false;
                }
                oneCount++;
            } else {
                zeroCount++;
            }
        }
        return oneCount != 32 && zeroCount != 32;
    }

    private static int[] toArray(String IP) {
        String[] splitIP = IP.split("\\.");
        int[] ipArr = new int[4];
        for (int i = 0; i < ipArr.length; i++) {
            ipArr[i] = Integer.parseInt(splitIP[i]);
        }
        return ipArr;
    }
}
