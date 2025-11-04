import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        HashSet<MyPoint> set = new HashSet<>();
        set.add(new MyPoint(0, 0));
        set.add(new MyPoint(0, 0));
        set.add(new MyPoint(0, 0));
        // set.remove(new MyPoint(0, 0));
        // set.remove(new MyPoint(0, 0));
        System.out.println(set.size());
    }
}
