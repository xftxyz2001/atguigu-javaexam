import java.util.HashSet;
import java.util.Scanner;

// ansererror 95
public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashSet<MyPoint> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char op = in.next().charAt(0);
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            if (op == 'd') {
                for (int x = x1; x < x2; x++) {
                    for (int y = y2; y < y1; y++) {
                        set.add(new MyPoint(x, y));
                    }
                }
            } else if (op == 'e') {
                for (int x = x1; x < x2; x++) {
                    for (int y = y2; y < y1; y++) {
                        set.remove(new MyPoint(x, y));
                    }
                }

            }
        }
        in.close();

        System.out.println(set.size());
    }
}

class MyPoint {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyPoint other = (MyPoint) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}