// !!!错误!!!
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class HJ16Obj {
    int V;
    int W;
    int Q;

    public int getVW() {
        return this.V * this.W;
    }

    @Override
    public String toString() {
        return "HJ16Obj [V=" + V + ", W=" + W + ", Q=" + Q + "]";
    }
}

public class HJ16 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 预算
        int m = in.nextInt(); // 查询到的物品总数

        HJ16Obj[] objs = new HJ16Obj[m];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new HJ16Obj();
            objs[i].V = in.nextInt(); // 物品的价格、v
            objs[i].W = in.nextInt(); // 重要度、w
            objs[i].Q = in.nextInt(); // 主件编号、q
        }
        in.close();
        HJ16Obj[] sortedObjs = new HJ16Obj[m];
        System.arraycopy(objs, 0, sortedObjs, 0, m);
        Arrays.sort(sortedObjs, (obj1, obj2) -> obj2.getVW() - obj1.getVW());

        ArrayList<HJ16Obj> list = new ArrayList<>();
        for (int i = 0; i < sortedObjs.length; i++) {
            if (n >= sortedObjs[i].V) {
                if (sortedObjs[i].Q == 0) { // 主件
                    list.add(sortedObjs[i]);
                    n -= sortedObjs[i].V;
                } else { // 非主件
                    HJ16Obj q = objs[sortedObjs[i].Q - 1];
                    if (list.contains(q)) { // 已经买过主件
                        list.add(sortedObjs[i]);
                        n -= sortedObjs[i].V;
                    } else {
                        if (n >= sortedObjs[i].V + q.V) { // 钱还够买主件
                            list.add(q);
                            n -= q.V;
                            list.add(sortedObjs[i]);
                            n -= sortedObjs[i].V;
                        }
                    }
                }
            }
        }

        int myd = 0;
        for (HJ16Obj hj16Obj : list) {
            myd += hj16Obj.getVW();
        }
        System.out.println(myd);
    }
}
