import java.util.Arrays;
import java.util.Scanner;

class HJ68Student {
    String name;
    int score;

    public HJ68Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }

}

public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int op = in.nextInt();

        HJ68Student[] students = new HJ68Student[n];
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int score = in.nextInt();
            students[i] = new HJ68Student(name, score);
        }
        in.close();

        if (op == 0) {
            Arrays.sort(students, (s1, s2) -> s2.score - s1.score);
        } else if (op == 1) {
            Arrays.sort(students, (s1, s2) -> s1.score - s2.score);
        }

        for (HJ68Student s : students) {
            System.out.println(s);
        }
    }
}
