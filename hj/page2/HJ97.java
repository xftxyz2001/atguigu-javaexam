import java.util.Scanner;

public class HJ97 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        int lt0cnt = 0;
        int gt0cnt = 0;
        double gt0sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                lt0cnt++;
            } else if (arr[i] > 0) {
                gt0cnt++;
                gt0sum += arr[i];
            }
        }
        double avg = 0;
        if (gt0cnt > 0) { // 可能为0
            avg = gt0sum / gt0cnt;
        }
        System.out.println(lt0cnt + " " + avg);

    }
}
