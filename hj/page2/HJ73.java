import java.util.Scanner;

public class HJ73 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        in.close();

        switch (month) {
            case 12:
                day += 30;
            case 11:
                day += 31;
            case 10:
                day += 30;
            case 9:
                day += 31;
            case 8:
                day += 31;
            case 7:
                day += 30;
            case 6:
                day += 31;
            case 5:
                day += 30;
            case 4:
                day += 31;
            case 3:
                day += (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
            case 2:
                day += 31;
            case 1:
        }

        System.out.println(day);
    }
}
