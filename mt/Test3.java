import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        final String MEI = "mei";
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        int index = str.indexOf(MEI);
        int l = index - 0;
        int r = str.length() - index - 3;
        
        int count = 0;
        // // 不删
        // if (str.indexOf(MEI) != -1) {
        //     count++;
        // }
        // // 删1个
        // for (int i = 0; i < str.length(); i++) {
        //     StringBuilder sb = new StringBuilder(str);
        //     sb.deleteCharAt(i);
        //     if (sb.indexOf(MEI) != -1) {
        //         count++;
        //     }
        // }
        // // ...
        System.out.println(count);

    }
}
