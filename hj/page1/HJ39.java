import java.util.ArrayList;
import java.util.Scanner;

public class HJ39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        in.close();

        for (int i = 0; i < lines.size(); i += 3) {
            String ip0 = lines.get(i);
            String ip1 = lines.get(i + 1);
            String ip2 = lines.get(i + 2);
            System.out.println(sameSubNet(ip0, ip1, ip2));
        }
    }

    private static int sameSubNet(String ip0, String ip1, String ip2) {
        try {
            int lip0 = toint(ip0);
            if (!valid(lip0)) {
                return 1;
            }

            int lip1 = toint(ip1);
            int lip2 = toint(ip2);
            if ((lip0 & lip1) == (lip0 & lip2)) {
                return 0;
            } else {
                return 2;
            }
        } catch (Exception ex) {
            return 1;
        }
    }

    private static boolean valid(int lip0) {
        while ((lip0 & 0x80000000) == 0x80000000) {
            lip0 <<= 1;
        }
        return lip0 == 0;
    }

    private static int toint(String ip) {
        int res = 0;
        String[] split = ip.split("\\.");
        for (int i = 0; i < split.length; i++) {
            int i1 = Integer.parseInt(split[i]);
            if (i1 < 0 || i1 > 255) {
                throw new RuntimeException("ip invalid.");
            }
            // String bs = Integer.toBinaryString(i1);
            res = (res << 8) | i1;
        }
        return res;
    }
}
