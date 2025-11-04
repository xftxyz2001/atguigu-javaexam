import java.util.Scanner;
import java.util.StringJoiner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.next();
        long num = in.nextLong();
        in.close();

        System.out.println(encode(ip));
        System.out.println(decode(num));
    }

    private static String decode(long num) {
        String bs = Long.toBinaryString(num);
        int[] nums = new int[4];
        for (int i = 0; i < nums.length; i++) {
            int start = bs.length() - 8 * (i + 1);
            int end = bs.length() - 8 * i;
            String substring = bs.substring(start < 0 ? 0 : start, end);
            nums[nums.length - i - 1] = Integer.parseInt(substring, 2);
        }
        StringJoiner sj = new StringJoiner(".");
        for (int i = 0; i < nums.length; i++) {
            sj.add(String.valueOf(nums[i]));
        }
        return sj.toString();
    }

    private static long encode(String ip) {
        String[] split = ip.split("\\.");
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String bs = Integer.toBinaryString(Integer.parseInt(split[i]));
            StringBuilder sb2 = new StringBuilder(bs);
            while (sb2.length() < 8) {
                sb2.insert(0, '0');
            }
            sb1.append(sb2);
        }
        return Long.parseLong(sb1.toString(), 2);
    }
}
// 00001010 00000000 00000011 11000001
// 00001010 00001010 00001010 00001010