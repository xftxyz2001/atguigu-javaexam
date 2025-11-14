import java.util.LinkedList;

public class T9 {
    public static void main(String[] args) {
        String str = "12(3(123)1)23";

        StringBuilder sb = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char chi = str.charAt(i);
            if (chi == '(') {
                stack.push(chi);
            } else if (chi == ')') {
                StringBuilder sb4stack = new StringBuilder();
                char chstack = '(';
                while ((chstack = stack.pop()) != '(') {
                    sb4stack.append(chstack);
                }
                if (stack.isEmpty()) {
                    sb.append(sb4stack);
                } else {
                    // stack.push('(');
                    for (int j = 0; j < sb4stack.length(); j++) {
                        stack.push(sb4stack.charAt(j));
                    }
                }
            } else if (stack.isEmpty()) {
                sb.append(chi);
            } else {
                stack.push(chi);
            }
        }
        System.out.println(sb.toString());
    }
}
