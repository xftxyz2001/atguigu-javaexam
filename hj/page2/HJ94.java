import java.util.HashMap;
import java.util.Scanner;

public class HJ94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        String[] cddt = new String[n];

        for (int i = 0; i < n; i++) {
            cddt[i] = in.next();
            map.put(cddt[i], 0);
        }

        int inv = 0;
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String tkt = in.next();
            if (map.containsKey(tkt)) {
                map.put(tkt, map.get(tkt) + 1);
            } else {
                inv++;
            }
        }
        in.close();

        for (int i = 0; i < cddt.length; i++) {
            System.out.println(cddt[i] + " : " + map.get(cddt[i]));
        }
        System.out.println("Invalid : " + inv);

    }
}
