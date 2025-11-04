import java.util.ArrayList;
import java.util.Scanner;

public class HJ74 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        in.close();

        ArrayList<String> argList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        boolean yinhao = false;
        for (int i = 0; i < nextLine.length(); i++) {
            char ch = nextLine.charAt(i);
            if (ch == ' ' && !yinhao) {
                argList.add(sb.toString());
                sb.setLength(0);
            } else if (ch == '"') {
                yinhao = !yinhao;
            } else {
                sb.append(ch);
            }
        }
        if (sb.length() > 0) {
            argList.add(sb.toString());
        }
        
        System.out.println(argList.size());
        for (String arg : argList) {
            System.out.println(arg);
        }
    }
}
