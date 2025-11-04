import java.util.Scanner;

public class HJ87 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pwd = in.nextLine();
        in.close();

        int d = 0;
        int A = 0;
        int a = 0;
        int f = 0;

        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);
            if (Character.isDigit(ch)) {
                d++;
            } else if (Character.isUpperCase(ch)) {
                A++;
            } else if (Character.isLowerCase(ch)) {
                a++;
            } else {
                f++;
            }
        }

        int score = 0;
        if (pwd.length() <= 4) {
            score += 5;
        } else if (pwd.length() <= 7) {
            score += 10;
        } else {
            score += 25;
        }

        if (A == 0 && a != 0 || A != 0 && a == 0) {
            score += 10;
        } else if (A != 0 && a != 0) {
            score += 20;
        }

        if (d == 1) {
            score += 10;
        } else if (d > 1) {
            score += 20;
        }

        if (f == 1) {
            score += 10;
        } else if (f > 1) {
            score += 25;
        }

        if (A > 0 && a > 0 && d > 0 && f > 0) {
            score += 5;
        } else if ((A + a > 0) && d > 0 && f > 0) {
            score += 3;
        } else if ((A + a > 0) && d > 0) {
            score += 2;
        }

        if (score >= 90) {
            System.out.println("VERY_SECURE");
        } else if (score >= 80) {
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else if (score >= 0) {
            System.out.println("VERY_WEAK");
        }

    }
}
