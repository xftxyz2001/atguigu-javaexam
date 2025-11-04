import java.util.ArrayList;
import java.util.Scanner;

class HJ49Person {
    int no;
    int score;
}

public class HJ49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 报名人数
        int m = in.nextInt(); // 计划录取人数

        ArrayList<HJ49Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HJ49Person p = new HJ49Person();
            p.no = in.nextInt(); // 报名号
            p.score = in.nextInt(); // 笔试成绩
            list.add(p);
        }
        in.close();

        // List<HJ49Person> newList = list.stream().sorted((o1, o2) -> {
        // int score = o2.score - o1.score;
        // if (score != 0) {
        // return score;
        // }
        // return o1.no = o2.no;
        // }).limit((int) (m * 1.5))
        // .collect(Collectors.toList());
        list.sort((o1, o2) -> {
            int score = o2.score - o1.score;
            if (score != 0) {
                return score;
            }
            // return o1.no = o2.no; // 无敌的bug
            return o1.no - o2.no;
        });
        int num = (int) (m * 1.5);
        int line = list.get(num - 1).score;
        int cnt = num;
        for (int i = num; i < list.size(); i++) {
            if (list.get(i).score >= line) {
                cnt++;
            }
        }
        System.out.println(line + " " + cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(list.get(i).no + " " + list.get(i).score);
        }

    }
}
