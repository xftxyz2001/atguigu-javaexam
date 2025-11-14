import java.util.LinkedList;

public class L32 {
    public static void main(String[] args) {
        new L32().longestValidParentheses("(()");
    }

    public int longestValidParentheses(String s) {
        int longest = 0;
        int curlong = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char chi = s.charAt(i);
            if (chi == '(') {
                if (stack.isEmpty()) {
                    if (curlong > longest) {
                        longest = curlong;
                    }
                    curlong = 0;
                }
                stack.push(chi);
            } else {
                if (stack.isEmpty()) {
                    if (curlong > longest) {
                        longest = curlong;
                    }
                    curlong = 0;
                } else {
                    stack.pop();
                    curlong += 2;
                }
            }
        }
        if (curlong > longest) {
            longest = curlong;
        }
        return longest;
    }
}
