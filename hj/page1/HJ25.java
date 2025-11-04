import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class HJ25Match {
    int index;
    String match;
    String rule;

    public HJ25Match(int index, String match, String rule) {
        this.index = index;
        this.match = match;
        this.rule = rule;
    }

}

public class HJ25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cntI = in.nextInt();
        ArrayList<String> I = new ArrayList<>(cntI);
        for (int j = 0; j < cntI; j++) {
            I.add(in.next());
        }

        int cntR = in.nextInt();
        HashSet<String> R = new HashSet<>();
        for (int j = 0; j < cntR; j++) {
            R.add(in.next());
        }
        in.close();

        ArrayList<String> r = new ArrayList<>(R);
        r.sort((s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));

        int cnt = 0;
        ArrayList<ArrayList<HJ25Match>> result = new ArrayList<>();
        for (int j = 0; j < r.size(); j++) {
            String r0 = r.get(j);
            ArrayList<HJ25Match> matchs = new ArrayList<>();
            for (int k = 0; k < I.size(); k++) {
                String i0 = I.get(k);
                if (i0.contains(r0)) {
                    matchs.add(new HJ25Match(k, i0, r0));
                }
            }
            if (matchs.size() > 0) {
                result.add(matchs);
                cnt += 2; // 规则and条数
                cnt += matchs.size() * 2;
            }
        }

        System.out.print(cnt + " ");
        for (int j = 0; j < result.size(); j++) {
            ArrayList<HJ25Match> matchs = result.get(j);
            System.out.print(matchs.get(0).rule + " ");
            System.out.print(matchs.size() + " ");
            for (int k = 0; k < matchs.size(); k++) {
                System.out.print(matchs.get(k).index + " " + matchs.get(k).match);
                if (k != matchs.size() - 1 || j != result.size() - 1) {
                    System.out.print(" ");
                }
            }

        }
    }
}
